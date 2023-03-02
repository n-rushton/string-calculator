package com.codurance.calculator.lexer.lexerTokenParsers;

import com.codurance.calculator.lexer.LexerToken;
import com.codurance.calculator.lexer.TokenType;

public class MultiplicationParser extends LexerTokenParser {

  public MultiplicationParser() {
    super.regex = "\\*";
    super.tokenType = TokenType.MULTIPLICATION;
  }

  @Override
  public LexerToken createToken(String foundString, int startingPos) {
    return new LexerToken(tokenType, foundString, startingPos);
  }
}
