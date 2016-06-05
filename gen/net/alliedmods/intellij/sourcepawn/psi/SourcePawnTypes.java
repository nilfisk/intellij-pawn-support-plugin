// This is a generated file. Not intended for manual editing.
package net.alliedmods.intellij.sourcepawn.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import net.alliedmods.intellij.sourcepawn.psi.impl.*;

public interface SourcePawnTypes {

  IElementType BOOLEAN_LITERAL = new SourcePawnElementType("BOOLEAN_LITERAL");
  IElementType EXPRESSION = new SourcePawnElementType("EXPRESSION");
  IElementType NUMBER = new SourcePawnElementType("NUMBER");
  IElementType PRAGMA_DIRECTIVE = new SourcePawnElementType("PRAGMA_DIRECTIVE");
  IElementType PREPROCESSOR_DIRECTIVE = new SourcePawnElementType("PREPROCESSOR_DIRECTIVE");

  IElementType ACQUIRE = new SourcePawnTokenType("acquire");
  IElementType ADDEQ = new SourcePawnTokenType("+=");
  IElementType AMPERSAND = new SourcePawnTokenType("&");
  IElementType AND = new SourcePawnTokenType("&&");
  IElementType ANDEQ = new SourcePawnTokenType("&=");
  IElementType AS = new SourcePawnTokenType("as");
  IElementType ASSERT = new SourcePawnTokenType("assert");
  IElementType ASSIGN = new SourcePawnTokenType("=");
  IElementType ASTERISK = new SourcePawnTokenType("*");
  IElementType BINARY_LITERAL = new SourcePawnTokenType("binary_literal");
  IElementType BLOCK_COMMENT = new SourcePawnTokenType("block_comment");
  IElementType BREAK = new SourcePawnTokenType("break");
  IElementType BUILTIN = new SourcePawnTokenType("builtin");
  IElementType CARET = new SourcePawnTokenType("^");
  IElementType CASE = new SourcePawnTokenType("case");
  IElementType CAST_TO = new SourcePawnTokenType("cast_to");
  IElementType CATCH = new SourcePawnTokenType("catch");
  IElementType CELLBITS = new SourcePawnTokenType("cellbits");
  IElementType CELLMAX = new SourcePawnTokenType("cellmax");
  IElementType CELLMIN = new SourcePawnTokenType("cellmin");
  IElementType CELLSOF = new SourcePawnTokenType("cellsof");
  IElementType CHAR = new SourcePawnTokenType("char");
  IElementType CHARACTER_STRING = new SourcePawnTokenType("character_string");
  IElementType CHARBITS = new SourcePawnTokenType("charbits");
  IElementType CHARMAX = new SourcePawnTokenType("charmax");
  IElementType CHARMIN = new SourcePawnTokenType("charmin");
  IElementType COMMA = new SourcePawnTokenType(",");
  IElementType CONST = new SourcePawnTokenType("const");
  IElementType CONTINUE = new SourcePawnTokenType("continue");
  IElementType DEBUG = new SourcePawnTokenType("debug");
  IElementType DECIMAL_LITERAL = new SourcePawnTokenType("decimal_literal");
  IElementType DECL = new SourcePawnTokenType("decl");
  IElementType DECREMENT = new SourcePawnTokenType("--");
  IElementType DEFAULT = new SourcePawnTokenType("default");
  IElementType DEFINED = new SourcePawnTokenType("defined");
  IElementType DELETE = new SourcePawnTokenType("delete");
  IElementType DIVEQ = new SourcePawnTokenType("/=");
  IElementType DO = new SourcePawnTokenType("do");
  IElementType DOUBLE = new SourcePawnTokenType("double");
  IElementType ELLIPSIS = new SourcePawnTokenType("...");
  IElementType ELSE = new SourcePawnTokenType("else");
  IElementType ENUM = new SourcePawnTokenType("enum");
  IElementType EOS = new SourcePawnTokenType("EOS");
  IElementType EQUALTO = new SourcePawnTokenType("==");
  IElementType EXCLAMATION = new SourcePawnTokenType("!");
  IElementType EXIT = new SourcePawnTokenType("exit");
  IElementType EXPLICIT = new SourcePawnTokenType("explicit");
  IElementType FALSE = new SourcePawnTokenType("false");
  IElementType FINALLY = new SourcePawnTokenType("finally");
  IElementType FOR = new SourcePawnTokenType("for");
  IElementType FOREACH = new SourcePawnTokenType("foreach");
  IElementType FORWARD = new SourcePawnTokenType("forward");
  IElementType FUNCENUM = new SourcePawnTokenType("funcenum");
  IElementType FUNCTAG = new SourcePawnTokenType("functag");
  IElementType FUNCTION = new SourcePawnTokenType("function");
  IElementType GOTO = new SourcePawnTokenType("goto");
  IElementType GT = new SourcePawnTokenType(">");
  IElementType GTEQ = new SourcePawnTokenType(">=");
  IElementType HASH = new SourcePawnTokenType("#");
  IElementType HEXADECIMAL_LITERAL = new SourcePawnTokenType("hexadecimal_literal");
  IElementType IDENTIFIER = new SourcePawnTokenType("identifier");
  IElementType IF = new SourcePawnTokenType("if");
  IElementType IMPLICIT = new SourcePawnTokenType("implicit");
  IElementType IMPORT = new SourcePawnTokenType("import");
  IElementType IN = new SourcePawnTokenType("in");
  IElementType INCREMENT = new SourcePawnTokenType("++");
  IElementType INT = new SourcePawnTokenType("int");
  IElementType INT16 = new SourcePawnTokenType("int16");
  IElementType INT32 = new SourcePawnTokenType("int32");
  IElementType INT64 = new SourcePawnTokenType("int64");
  IElementType INT8 = new SourcePawnTokenType("int8");
  IElementType INTERFACE = new SourcePawnTokenType("interface");
  IElementType INTN = new SourcePawnTokenType("intn");
  IElementType INVALID_FUNCTION = new SourcePawnTokenType("INVALID_FUNCTION");
  IElementType LBRACE = new SourcePawnTokenType("{");
  IElementType LBRACKET = new SourcePawnTokenType("[");
  IElementType LET = new SourcePawnTokenType("let");
  IElementType LINE_COMMENT = new SourcePawnTokenType("line_comment");
  IElementType LPAREN = new SourcePawnTokenType("(");
  IElementType LT = new SourcePawnTokenType("<");
  IElementType LTEQ = new SourcePawnTokenType("<=");
  IElementType METHODMAP = new SourcePawnTokenType("methodmap");
  IElementType MINUS = new SourcePawnTokenType("-");
  IElementType MODEQ = new SourcePawnTokenType("%=");
  IElementType MULEQ = new SourcePawnTokenType("*=");
  IElementType NAMESPACE = new SourcePawnTokenType("namespace");
  IElementType NATIVE = new SourcePawnTokenType("native");
  IElementType NEQUALTO = new SourcePawnTokenType("!=");
  IElementType NEW = new SourcePawnTokenType("new");
  IElementType NULL = new SourcePawnTokenType("null");
  IElementType NULLABLE = new SourcePawnTokenType("__nullable__");
  IElementType OBJECT = new SourcePawnTokenType("object");
  IElementType OPERATOR = new SourcePawnTokenType("operator");
  IElementType OR = new SourcePawnTokenType("||");
  IElementType OREQ = new SourcePawnTokenType("|=");
  IElementType PACKAGE = new SourcePawnTokenType("package");
  IElementType PERCENT = new SourcePawnTokenType("%");
  IElementType PERIOD = new SourcePawnTokenType(".");
  IElementType PLUS = new SourcePawnTokenType("+");
  IElementType PRAGMA = new SourcePawnTokenType("pragma");
  IElementType PRAGMA_CTRLCHAR = new SourcePawnTokenType("ctrlchar");
  IElementType PRAGMA_SEMICOLON = new SourcePawnTokenType("semicolon");
  IElementType PRIVATE = new SourcePawnTokenType("private");
  IElementType PROTECTED = new SourcePawnTokenType("protected");
  IElementType PUBLIC = new SourcePawnTokenType("public");
  IElementType RANGE = new SourcePawnTokenType("..");
  IElementType RATIONAL_LITERAL = new SourcePawnTokenType("rational_literal");
  IElementType RBRACE = new SourcePawnTokenType("}");
  IElementType RBRACKET = new SourcePawnTokenType("]");
  IElementType READONLY = new SourcePawnTokenType("readonly");
  IElementType RETURN = new SourcePawnTokenType("return");
  IElementType RPAREN = new SourcePawnTokenType(")");
  IElementType SCOPE_RESOLUTION = new SourcePawnTokenType("::");
  IElementType SEALED = new SourcePawnTokenType("sealed");
  IElementType SEMICOLON = new SourcePawnTokenType(";");
  IElementType SIZEOF = new SourcePawnTokenType("sizeof");
  IElementType SL = new SourcePawnTokenType("<<");
  IElementType SLASH = new SourcePawnTokenType("/");
  IElementType SLEEP = new SourcePawnTokenType("sleep");
  IElementType SLEQ = new SourcePawnTokenType("<<=");
  IElementType SP_VERSION = new SourcePawnTokenType("__Pawn");
  IElementType SRA = new SourcePawnTokenType(">>");
  IElementType SRAEQ = new SourcePawnTokenType(">>=");
  IElementType SRL = new SourcePawnTokenType(">>>");
  IElementType SRLEQ = new SourcePawnTokenType(">>>=");
  IElementType STATIC = new SourcePawnTokenType("static");
  IElementType STOCK = new SourcePawnTokenType("stock");
  IElementType STRING_LITERAL = new SourcePawnTokenType("string_literal");
  IElementType STRUCT = new SourcePawnTokenType("struct");
  IElementType SUBEQ = new SourcePawnTokenType("-=");
  IElementType SWITCH = new SourcePawnTokenType("switch");
  IElementType TAGOF = new SourcePawnTokenType("tagof");
  IElementType THIS = new SourcePawnTokenType("this");
  IElementType THROW = new SourcePawnTokenType("throw");
  IElementType TILDE = new SourcePawnTokenType("~");
  IElementType TRUE = new SourcePawnTokenType("true");
  IElementType TRY = new SourcePawnTokenType("try");
  IElementType TYPEDEF = new SourcePawnTokenType("typedef");
  IElementType TYPEOF = new SourcePawnTokenType("typeof");
  IElementType TYPESET = new SourcePawnTokenType("typeset");
  IElementType UCHARMAX = new SourcePawnTokenType("ucharmax");
  IElementType UINT16 = new SourcePawnTokenType("uint16");
  IElementType UINT32 = new SourcePawnTokenType("uint32");
  IElementType UINT64 = new SourcePawnTokenType("uint64");
  IElementType UINT8 = new SourcePawnTokenType("uint8");
  IElementType UINTN = new SourcePawnTokenType("uintn");
  IElementType UNION = new SourcePawnTokenType("union");
  IElementType USING = new SourcePawnTokenType("using");
  IElementType VAR = new SourcePawnTokenType("var");
  IElementType VARIANT = new SourcePawnTokenType("variant");
  IElementType VERTICAL_BAR = new SourcePawnTokenType("|");
  IElementType VIEW_AS = new SourcePawnTokenType("view_as");
  IElementType VIRTUAL = new SourcePawnTokenType("virtual");
  IElementType VOID = new SourcePawnTokenType("void");
  IElementType VOLATILE = new SourcePawnTokenType("volatile");
  IElementType WHILE = new SourcePawnTokenType("while");
  IElementType WITH = new SourcePawnTokenType("with");
  IElementType XOREQ = new SourcePawnTokenType("^=");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == BOOLEAN_LITERAL) {
        return new SourcePawnBooleanLiteralImpl(node);
      }
      else if (type == EXPRESSION) {
        return new SourcePawnExpressionImpl(node);
      }
      else if (type == NUMBER) {
        return new SourcePawnNumberImpl(node);
      }
      else if (type == PRAGMA_DIRECTIVE) {
        return new SourcePawnPragmaDirectiveImpl(node);
      }
      else if (type == PREPROCESSOR_DIRECTIVE) {
        return new SourcePawnPreprocessorDirectiveImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
