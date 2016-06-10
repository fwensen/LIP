package com.vincent.pattern2;

public class Test {

	public static void main(String[] args) {
		
		ListLexer lexer = new ListLexer("[a, bcd, c]");
		Token t = lexer.nextToken();
		while (t.type != Lexer.EOF_TYPE) {
			System.out.println(t);
			t = lexer.nextToken();
		}
		System.out.println(t);
	}
	

}
