
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
* A class which represents HashMap of all valid possible tokens in my TOOL - Programming Language
* */

import java.util.*;

public abstract class ValidTokens {

    public static List<Character> getAllValidOperators(){
        List<Character> allValidTokens = new ArrayList<>();
        allValidTokens.add('/');
        allValidTokens.add('+');
        allValidTokens.add('-');
        allValidTokens.add('*');
        allValidTokens.add('%');
        allValidTokens.add('<');
        allValidTokens.add('>');
        return allValidTokens;
    }

    public static List<Character> getAllValidParenthesis(){
        List<Character> allValidTokens = new ArrayList<>();
        allValidTokens.add('(');
        allValidTokens.add(')');
        allValidTokens.add('{');
        allValidTokens.add('}');
        allValidTokens.add('[');
        allValidTokens.add(']');
        return allValidTokens;
    }

    public static List<String> getAllValidKeywords(){
        List<String> allValidTokens = new ArrayList<>();
        allValidTokens.addAll(Arrays.asList(new String[]{"if", "else", "for", "while", "do", "switch", "case",
                "default", "class", "void", "float", "int", "byte", "short", "long", "public",
                "protected", "final", "static", "extends", "String", "main"}));
        return allValidTokens;
    }

    public static char getQuotationMark(){
        return '\'';
    }

}
