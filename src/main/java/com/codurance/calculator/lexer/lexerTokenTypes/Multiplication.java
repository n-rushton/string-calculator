package com.codurance.calculator.lexer.lexerTokenTypes;

import com.codurance.calculator.lexer.TokenType;

public class Multiplication extends LexerTokenType{

  public Multiplication() {
    super.regex = "\\*";
    super.tokenType = TokenType.MULTIPLICATION;
  }
}
