
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
* An enumeration of all possible Token Classes in TOOL - my Programming Language
* */

public enum TokenClass {

    DIGIT("Digit"),
    OPERATOR("Operator"),
    PARENTHESIS("Parenthesis"),
    KEYWORD("Keyword"),
    IDENTIFIER("Identifier"),
    WHITESPACE("Whitespace"),
    LETTER("Letter"),
    QUOTATION_MARK("Quotation Mark"),
    STRING_LITERAL("String Literal"),
    UNKNOWN("?UNKNOWN?");


    private String tokenClassName;
    TokenClass(String tokenClassName){
        this.tokenClassName = tokenClassName;
    }


    @Override
    public String toString() {
        return tokenClassName;
    }
}
