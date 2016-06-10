package com.vincent.pattern2;

public class ListLexer extends Lexer{

	/**
	 * 词法类型
	 * 
	 */
	public static int NAME = 2; //代表各种标志符
	public static int COMMA = 3; //逗号
	public static int LBRACK = 4; //左括号
	public static int RBRACK = 5; //右括号
	public static String[] tokenNames = 
		{"n/a", "<EOF>", "NAME", "COMMA", "LBRACK", "RBRACK"};
	
	public ListLexer(String input) {
		super(input);
	}
	
	boolean isLETTER() {
		return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
	}

	@Override
	public Token nextToken() {
		while (c != EOF) {
			switch (c) {
				case ' ' : case '\t' : case '\n': case '\r': 
					WS(); continue;
				case ',': consume(); return new Token(COMMA, ",");
				case '[': consume(); return new Token(LBRACK, "[");
				case ']': consume(); return new Token(RBRACK, "]");
				default:
					/**
					 * 如果向前看是字符，即不是以上几种，则应该收集暂存所有紧随其后的字母
					 */
					if (isLETTER()) return NAME();
					throw new Error("invalid character: " + c);
			}
			
		}
		return new Token(EOF_TYPE, "<EOF>");
	}

	@Override
	public String getTokenName(int tokenType) {
		return null;
	}
	
	/**
	 * NAME: ('a','b'...'z'|'A','B',...'Z') NAME由一个或多个字母组成
	 * @return
	 */
	Token NAME() {
		StringBuilder buf = new StringBuilder();
		do {buf.append(c); consume(); } while ( isLETTER() );
		return new Token(NAME, buf.toString());
	}
	/**
	 * 空格, '\t', '\n'....
	 */
	void WS() {
		while (c == ' ' || c == '\t' || c == '\n' || c == '\r') 
			consume();
	}
	
}
