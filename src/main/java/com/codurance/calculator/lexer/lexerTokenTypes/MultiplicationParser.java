package com.codurance.calculator.lexer.lexerTokenTypes;

import com.codurance.calculator.lexer.LexerToken;
import com.codurance.calculator.lexer.TokenType;

public class MultiplicationParser extends LexerTokenParser {

  public MultiplicationParser() {
    super.regex = "\\*";
    super.tokenType = TokenType.MULTIPLICATION;
  }

  @Override
  public LexerToken createToken(TokenType tokenType, String foundString, int startingPos) {
    throw new UnsupportedOperationException();
  }
}
