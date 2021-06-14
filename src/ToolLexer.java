

/*
-------------------------------------------------------
|   TOOL = TALHA Object Oriented Language
|   LEXICAL ANALYSER FOR TOOL
|   13th November 2020
|   TALHA ASGHAR
|
------------------------------------------------------
 */

/*
 * A LEXical analysER of my TOOL - Programming Language
 * */

import java.util.ArrayList;
import java.util.List;

public class ToolLexer {

    private final String sourceCode;


    public ToolLexer(String sourceCode){
        this.sourceCode = sourceCode;
    }

    public List<Token> generateTokens() throws InvalidTokenException {

        List<Token> tokenList = new ArrayList<>();
        String[] instructions = sourceCode.split("\n");


        for (int lineNumber = 0; lineNumber < instructions.length; lineNumber++) {
            String instruction = instructions[lineNumber];
            ToolTokenizer tokenizer = new ToolTokenizer(instruction);
            while (tokenizer.hasNext()) {
                switch (tokenizer.getTokenClassOfCurrentChar()){
                    case OPERATOR:
                        tokenList.add(new Token(TokenClass.OPERATOR.toString(), tokenizer.nextOperator(), lineNumber));
                        break;
                    case DIGIT:
                        tokenList.add(new Token(TokenClass.DIGIT.toString(), tokenizer.nextDigit(), lineNumber));
                        break;
                    case PARENTHESIS:
                        tokenList.add(new Token(TokenClass.PARENTHESIS.toString(), tokenizer.nextParenthesis(), lineNumber));
                        break;
                    case WHITESPACE:
                        tokenizer.skipIfWhitespace();
                        break;
                    case LETTER:
                        String lexeme = tokenizer.nextKeywordOrIdentifier();
                        boolean isKeyword = tokenizer.isKeyword(lexeme);
                        TokenClass lexemeType = isKeyword ? TokenClass.KEYWORD : TokenClass.IDENTIFIER;
                        tokenList.add(new Token(lexemeType.toString(), lexeme, lineNumber));
                        break;
                    case QUOTATION_MARK:
                        tokenList.add(new Token(TokenClass.STRING_LITERAL.toString(), tokenizer.nextStringLiteral(), lineNumber));
                        break;
                    default:
                        // invalid token
                        throw new InvalidTokenException(lineNumber, tokenizer.getCharPos(), tokenizer.getCurrentChar());

                }
            }

        }


        return tokenList;
    }

}
