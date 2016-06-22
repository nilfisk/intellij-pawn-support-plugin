package net.sourcemod.sourcepawn.lexer;

import com.google.common.base.Preconditions;

import com.intellij.lexer.LexerBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.text.CharArrayUtil;

import net.sourcemod.sourcepawn.util.OffsetCharSequence;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpLexer extends LexerBase {

  @NotNull
  private final _SpLexer spFlexLexer;

  private final StringBuilder PATTERN_BUILDER = new StringBuilder(32);
  private final Map<String, Pattern> PATTERN_PREFIXES = new HashMap<>();

  @Nullable
  private CharSequence buffer;

  @Nullable
  private char[] bufferChars;

  private int bufferIndex;
  private int bufferEndOffset;
  private int tokenEndOffset;

  @Nullable
  private IElementType tokenType;

  public SpLexer() {
    this.spFlexLexer = new _SpLexer();
  }

  public void define(@NotNull @NonNls String prefix, @NotNull @NonNls String postfix) {
    Preconditions.checkArgument(prefix != null, "prefix cannot be null");
    Preconditions.checkArgument(postfix != null, "postfix cannot be null");
    postfix = postfix.replaceAll("%[0-9]", ".*?");
    PATTERN_PREFIXES.put(prefix, Pattern.compile(postfix));
  }

  public void undef(@NotNull @NonNls String prefix) {
    PATTERN_PREFIXES.remove(prefix);
  }

  @Override
  public final void start(@NotNull CharSequence buffer, int startOffset, int endOffset, int initialState) {
    Preconditions.checkArgument(buffer != null, "buffer cannot be null");
    this.buffer = buffer;
    this.bufferChars = CharArrayUtil.fromSequenceWithoutCopying(buffer);
    this.bufferIndex = startOffset;
    this.bufferEndOffset = endOffset;
    this.tokenType = null;
    this.tokenEndOffset = startOffset;
    spFlexLexer.reset(buffer, startOffset, endOffset, _SpLexer.YYINITIAL);
  }

  @Override
  public int getState() {
    return 0;
  }

  @Nullable
  @Override
  public final IElementType getTokenType() {
    if (tokenType == null) {
      locateToken();
    }

    return tokenType;
  }

  @Override
  public final int getTokenStart() {
    return bufferIndex;
  }

  @Override
  public final int getTokenEnd() {
    if (tokenType == null) {
      locateToken();
    }

    return tokenEndOffset;
  }

  @Override
  public final void advance() {
    if (tokenType == null) {
      locateToken();
    }

    tokenType = null;
  }

  private char charAt(int pos) {
    return bufferChars == null ? buffer.charAt(bufferIndex) : bufferChars[bufferIndex];
  }

  private void locateToken() {
    if (tokenEndOffset == bufferEndOffset) {
      tokenType = null;
      bufferIndex = bufferEndOffset;
      return;
    }

    bufferIndex = tokenEndOffset;

    char ch = charAt(bufferIndex);
    switch (ch) {
      case ' ':
      case '\t':
      case '\f':
        tokenType = TokenType.WHITE_SPACE;
        tokenEndOffset = getWhitespaces(bufferIndex + 1);
        break;

      case '\r':
      case '\n':
        tokenType = SpTokenTypes.NEW_LINE;
        tokenEndOffset = getLineTerminator(bufferIndex);
        break;

      case '/':
        if (bufferIndex + 1 >= bufferEndOffset) {
          tokenType = SpTokenTypes.SLASH;
          tokenEndOffset = bufferEndOffset;
        } else {
          ch = charAt(bufferIndex + 1);
          switch (ch) {
            case '/':
              tokenType = SpTokenTypes.END_OF_LINE_COMMENT;
              tokenEndOffset = getUpToLineTerminator(bufferIndex + 2);
              break;
            case '*':
              if (bufferIndex + 2 >= bufferEndOffset
                  || charAt(bufferIndex + 2) != '*'
                  || (bufferIndex + 3 < bufferEndOffset && charAt(bufferIndex + 3) == '/')) {
                tokenType = SpTokenTypes.C_STYLE_COMMENT;
                tokenEndOffset = getClosingComment(bufferIndex + 2);
              } else {
                tokenType = SpTokenTypes.DOC_COMMENT;
                tokenEndOffset = getClosingComment(bufferIndex + 3);
              }

              break;
            default:
              locateFlexToken();
          }
        }

        break;

      case '"':
      case '\'':
        tokenType = ch == '"' ? SpTokenTypes.STRING_LITERAL : SpTokenTypes.CHARACTER_LITERAL;
        tokenEndOffset = getClosingQuote(bufferIndex + 1, ch);
        break;

      default:
        if (SpUtils.isAlpha(bufferIndex) && !PATTERN_PREFIXES.isEmpty()) {
          PATTERN_BUILDER.setLength(0);
          PATTERN_BUILDER.append(ch);

          int pos = bufferIndex + 1;
          while (pos < bufferEndOffset) {
            ch = charAt(pos);
            if (!SpUtils.isAlphaNumeric(ch)) {
              break;
            }

            PATTERN_BUILDER.append(ch);
            pos++;
          }

          String prefix = PATTERN_BUILDER.toString();
          if (PATTERN_PREFIXES.containsKey(prefix)) {
            Pattern postfix = PATTERN_PREFIXES.get(prefix);
            if (postfix != null) {
              CharSequence offsetCharSequence = new OffsetCharSequence(buffer, pos);
              Matcher matcher = postfix.matcher(offsetCharSequence);
              if (matcher.lookingAt()) {
                pos += matcher.end();
              }
            }

            tokenType = SpTokenTypes.DEFINED_PATTERN;
            tokenEndOffset = pos;
          } else {
            locateFlexToken();
          }
        } else {
          locateFlexToken();
        }
    }

    if (tokenEndOffset > bufferEndOffset) {
      tokenEndOffset = bufferEndOffset;
    }
  }

  private void locateFlexToken() {
    try {
      spFlexLexer.goTo(bufferIndex);
      tokenType = spFlexLexer.advance();
      tokenEndOffset = spFlexLexer.getTokenEnd();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private int getWhitespaces(int offset) {
    if (offset >= bufferEndOffset) {
      return bufferEndOffset;
    }

    int pos = offset;
    char ch = charAt(pos);
    while (ch == ' ' || ch == '\t' || ch == '\f') {
      pos++;
      if (pos == bufferEndOffset) {
        break;
      }

      ch = charAt(pos);
    }

    return pos;
  }

  private int getLineTerminator(int offset) {
    if (offset >= bufferEndOffset) {
      return bufferEndOffset;
    }

    int pos = offset;
    char ch = charAt(pos);
    switch (ch) {
      case '\r':
        pos++;
        if (pos == bufferEndOffset) {
          break;
        }

        ch = charAt(pos);
        if (ch == '\n') {
          pos++;
        }

        break;

      case '\n':
        pos++;
        break;

      default:
        break;
    }

    return pos;
  }

  private int getUpToLineTerminator(int offset) {
    char ch;
    int pos = offset;
    while (pos < bufferEndOffset) {
      ch = charAt(pos);
      if (ch == '\r' || ch == '\n') {
        break;
      }

      pos++;
    }

    return pos;
  }

  private int getClosingComment(int offset) {
    char ch;
    int pos = offset;
    while (pos < bufferEndOffset - 1) {
      ch = charAt(pos);
      if (ch == '*' && charAt(pos + 1) == '/') {
        break;
      }

      pos++;
    }

    return pos + 2;
  }

  private int getClosingQuote(int offset, char quote) {
    if (offset >= bufferEndOffset) {
      return bufferEndOffset;
    }

    int pos = offset;
    char ch = charAt(pos);
    while (true) {
      while (ch != quote && ch != '\n' && ch != '\r' && ch != '\\') {
        pos++;
        if (pos >= bufferEndOffset) {
          return bufferEndOffset;
        }

        ch = charAt(pos);
      }

      if (ch == '\\') {
        pos++;
        if (pos >= bufferEndOffset) {
          return bufferEndOffset;
        }

        ch = charAt(pos);
        if (ch == '\n' || ch == '\r') {
          continue;
        }

        pos++;
        if (pos >= bufferEndOffset) {
          return bufferEndOffset;
        }

        ch = charAt(pos);
      } else if (ch == quote) {
        break;
      } else {
        pos--;
        break;
      }
    }

    return pos + 1;
  }

  @NotNull
  @Override
  public CharSequence getBufferSequence() {
    assert buffer != null : "start should have set buffer to a non-null reference";
    return buffer;
  }

  @Override
  public final int getBufferEnd() {
    return bufferEndOffset;
  }

}