package com.codurance.calculator.lexer.lexerTokenTypes;

import com.codurance.calculator.lexer.TokenType;

public class Addition extends LexerTokenType {

  public Addition() {
    super.regex = "\\+";
    super.tokenType = TokenType.ADDITION;
  }
}
