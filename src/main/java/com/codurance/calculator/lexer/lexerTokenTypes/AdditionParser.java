package com.codurance.calculator.lexer.lexerTokenTypes;

import com.codurance.calculator.lexer.TokenType;

public class AdditionParser extends LexerTokenParser {

  public AdditionParser() {
    super.regex = "\\+";
    super.tokenType = TokenType.ADDITION;
  }
}
