# TOOL-Compiler
TOOL is my own language with abbreviation of "Talha Object Oriented Language"

It is really an interesting thing for a programmer to create his own language and its compiler. 
I have started similar project while I am studying my Compiler Construction Course from Respected Sir, Safdar Hussain.
In this assignment, I have developed a Lexical Analyser for my own language, namely TOOL (Talha Object Oriented Language).
The basic things which this lexcial analyser can do is:
1. Scans the source code file .tool of TOOL language line by line.
2. Analyzes the code and extract the lexemes which can have any of the following Token Class:


I. Digit
II. OPERATOR
III. PARENTHESIS
IV. KEYWORD
V. IDENTIFIER
VI. WHITE SPACES
VII. LETTER
VIII. STRING LITERAL

3. Ignores the whitespaces.
4. Find Invalid Tokens and suggests the line and column number in which it is found by throwing InvalidTockenFoundException.
5. Prints the lexemes for all valid tokens with their corresponding token classes.
The Structure of the Lexical Analyser Project is:
1. InvalidTockenException.java # Throws an exception if invalid token is found
2. Main.java # Test Driver class
3. Token.java # Represents a Valid Token
4. TokenClass.java # An enum containing list of all token classes.
5. ToolLexer # Core code for Lexer of TOOL language
6. ToolTokenizer # Custom String tokenizer to identify tokens of TOOL language
7. Valid Tokens # List of all valid tokens. i.e. Keywords, Operators etc.


The TOOL languages is built on top of Java.
