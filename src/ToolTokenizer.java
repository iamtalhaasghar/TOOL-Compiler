
/*
-------------------------------------------------------
|   TOOL = TALHA Object Oriented Language
|   LEXICAL ANALYSER FOR TOOL
|   13th November 2020
|   TALHA ASGHAR
|
------------------------------------------------------
 */

import java.util.List;

public class ToolTokenizer {

    private String inputString;
    private int currentPos;

    public ToolTokenizer(String inputString){
        this.inputString = inputString;
    }


    public boolean hasNext(){
        return currentPos < inputString.length();
    }

    public boolean hasDigit(){
        return Character.isDigit(getCurrentChar());
    }

    public boolean hasParenthesis(){
        List<Character> tempList = ValidTokens.getAllValidParenthesis();
        for (Character character :
                tempList) {
            if(character == getCurrentChar()){
                return true;
            }
        }
        return false;
    }

    public boolean hasOperator(){
        List<Character> operators = ValidTokens.getAllValidOperators();
        for (Character operator :
                operators) {
            if(operator == getCurrentChar()){
                return true;
            }
        }
        return false;
    }


    public boolean hasWhitespace(){
        return Character.isWhitespace(getCurrentChar());
    }

    public boolean hasLetter(){
        return Character.isLetter(getCurrentChar());
    }

    public boolean hasQuotationMark(){
        return getCurrentChar() == ValidTokens.getQuotationMark();
    }

    public TokenClass getTokenClassOfCurrentChar(){
        TokenClass tokenClass = TokenClass.UNKNOWN;
        if (hasOperator()) {
            tokenClass = TokenClass.OPERATOR;
        } else if (hasDigit()) {
            tokenClass = TokenClass.DIGIT;
        }
        else if(hasParenthesis()){
            tokenClass = TokenClass.PARENTHESIS;
        }
        else if(hasWhitespace()){
            tokenClass = TokenClass.WHITESPACE;
        }
        else if(hasLetter()){
            tokenClass = TokenClass.LETTER;
        }
        else if(hasQuotationMark()){
            tokenClass = TokenClass.QUOTATION_MARK;
        }
        return tokenClass;
    }

    public Character getCurrentChar(){
        return inputString.charAt(currentPos);
    }

    public String getCurrentCharAsString(){
        return String.valueOf(getCurrentChar());
    }

    public int getCharPos(){
        return currentPos;
    }
    private void moveToNextChar(){
        currentPos++;
    }

    public void skipIfWhitespace(){
        if(hasWhitespace()){
            moveToNextChar();
        }
    }

    public String nextDigit(){
        StringBuffer digitBuffer = new StringBuffer();
        while(hasNext() && hasDigit()){
            digitBuffer.append(getCurrentCharAsString());
            moveToNextChar();
        }
        return digitBuffer.toString();
    }

    public String nextOperator(){
        StringBuffer operatorBuffer = new StringBuffer();
        if(hasNext() && hasOperator()){
            operatorBuffer.append(getCurrentCharAsString());
            moveToNextChar();
        }
        return operatorBuffer.toString();
    }

    public String nextParenthesis(){
        StringBuffer buffer = new StringBuffer();
        if(hasNext() && hasParenthesis()){
            buffer.append(getCurrentCharAsString());
            moveToNextChar();
        }
        return buffer.toString();
    }

    public String nextKeywordOrIdentifier(){
        StringBuffer buffer = new StringBuffer();
        while(hasNext() && hasLetter()){
            buffer.append(getCurrentCharAsString());
            moveToNextChar();
        }
        return buffer.toString();
    }
    public boolean isKeyword(String inputToken){
        List<String> tempList = ValidTokens.getAllValidKeywords();
        for (String keyword :
                tempList) {
            if(keyword.equals(inputToken)){
                return true;
            }
        }
        return false;
    }

    public String nextStringLiteral() throws InvalidTokenException {
        StringBuffer buffer = new StringBuffer();
        if(hasQuotationMark()){
            moveToNextChar();
            while(hasNext() && !hasQuotationMark()){
                buffer.append(getCurrentCharAsString());
                moveToNextChar();
            }
        }
        return buffer.toString();
    }
}
