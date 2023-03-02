package com.codurance.calculator.lexer.lexerTokenParsers;

import com.codurance.calculator.lexer.LexerToken;
import com.codurance.calculator.lexer.TokenType;

public class AdditionParser extends LexerTokenParser {

  public AdditionParser() {
    super.regex = "\\+";
    super.tokenType = TokenType.ADDITION;
  }

  @Override
  public LexerToken createToken(String foundString, int startingPos) {
    return new LexerToken(tokenType, foundString, startingPos);
  }
}
