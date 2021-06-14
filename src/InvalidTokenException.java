
/*
-------------------------------------------------------
|   TOOL = TALHA Object Oriented Language
|   LEXICAL ANALYSER FOR TOOL
|   13th November 2020
|   TALHA ASGHAR
|
------------------------------------------------------
 */

public class InvalidTokenException extends Exception{

    private int lineNumber;
    private int position;
    private char invalidToken;

    public InvalidTokenException(){}

    public InvalidTokenException(int lineNumber, int position, char invalidToken){
        this.lineNumber = lineNumber;
        this.position = position;
        this.invalidToken = invalidToken;
    }

    @Override
    public String toString() {
        return String.format("Invalid token \'%c\' found in line#%d at col#%d", invalidToken, lineNumber+1, position+1);
    }
}
