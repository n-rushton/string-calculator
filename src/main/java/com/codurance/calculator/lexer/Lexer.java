package com.codurance.calculator.lexer;

import com.codurance.calculator.lexer.lexerTokenTypes.LexerTokenType;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {

    public static final String SPACE = " ";
    private final List<LexerTokenType> lexerTokenTypes;
    List<LexerToken> lexerTokens = new ArrayList<>();

    Lexer(List<LexerTokenType> lexerTokenTypes) {
        this.lexerTokenTypes = lexerTokenTypes;
    }

    public List<LexerToken> lex(String equation) {

        lexerTokenTypes.forEach(lexerTokenType -> {
            extractTokens(equation, lexerTokenType.regex, lexerTokenType.tokenType);
        });


        lexerTokens.sort(LexerToken::compareTo);

        return lexerTokens;
    }

    private void extractTokens(String equation, String regex, TokenType tokenType) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(equation);

        while (matcher.find()) {
            String foundString = matcher.group(0);
            lexerTokens.add(new LexerToken(tokenType, foundString, matcher.start(0)));
        }
    }

}
