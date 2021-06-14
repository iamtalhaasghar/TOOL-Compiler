
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
 * A test driver class containing main method to test Lexical Analyser of my TOOL - Programming Language
 * */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // reader for code file
        try (BufferedReader fileReader = new BufferedReader(new FileReader("code.tool"))) {
            StringBuffer sourceCode = new StringBuffer();
            String line;
            while( (line = fileReader.readLine()) != null){
                sourceCode.append(line+"\n");
            }
            ToolLexer toolLexer = new ToolLexer(sourceCode.toString());

            List<Token> tokenList = toolLexer.generateTokens();
            for (Token token :
                    tokenList) {
                System.out.println(token);
            }


        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InvalidTokenException e) {
            System.out.println(e.toString());
        }


    }


}
