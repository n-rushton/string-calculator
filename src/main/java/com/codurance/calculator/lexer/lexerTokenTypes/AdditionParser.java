package com.codurance.calculator.lexer.lexerTokenTypes;

import com.codurance.calculator.lexer.LexerToken;
import com.codurance.calculator.lexer.TokenType;

public class AdditionParser extends LexerTokenParser {

  public AdditionParser() {
    super.regex = "\\+";
    super.tokenType = TokenType.ADDITION;
  }

  @Override
  public LexerToken createToken(TokenType tokenType, String foundString, int startingPos) {
    throw new UnsupportedOperationException();
  }
}
