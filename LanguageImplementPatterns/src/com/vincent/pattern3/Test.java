package com.vincent.pattern3;

import com.vincent.pattern2.ListLexer;

public class Test {

	public static void main(String[] args) {
		
		ListLexer lexer = new ListLexer("[a,b,d,[3,4,5,6],3]");
		ListParser parser = new ListParser(lexer);
		parser.list();
		
	}
	
}
