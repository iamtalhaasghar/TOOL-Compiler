
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
* A class to represent the Tokens of my TOOL - Programming Language
* */
public class Token {

    private String tokenClass;
    private String tokenValue;
    private int lineNumber;

    public Token(String tokenClass, String tokenValue, int lineNumber) {
        this.tokenClass = tokenClass;
        this.tokenValue = tokenValue;
        this.lineNumber = lineNumber;
    }

    public String getTokenClass() {
        return tokenClass;
    }

    public void setTokenClass(String tokenClass) {
        this.tokenClass = tokenClass;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public String toString() {
        return String.format("<< %s, %s, line#%d >>", tokenValue, tokenClass, lineNumber+1);
    }
}
