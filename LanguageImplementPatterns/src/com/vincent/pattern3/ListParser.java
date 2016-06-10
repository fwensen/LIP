package com.vincent.pattern3;

import com.vincent.pattern2.Lexer;
import com.vincent.pattern2.ListLexer;

/**
 * 语法解析，解析列表，列表中有
 * @author vincent
 *
 */
public class ListParser extends Parser{

	public ListParser(Lexer input) {
		super(input);
	}
	
	/**
	 * list: '[' elements ']] ; 匹配方括号
	 */
	public void list() {
		match(ListLexer.LBRACK); //期望'['
		elements();              //期望elements
		match(ListLexer.RBRACK); //期望']'
	}
	/**
	 * elements: element (',' element)*
	 */
	void elements() {
		element();
		while (lookahead.type == ListLexer.COMMA) {
			match(ListLexer.COMMA);
			element();
		}
	}
	/**
	 * element: name | list; 一个element要么是NAME，要么是嵌套的list
	 */
	void element() {
		
		if(lookahead.type == ListLexer.NAME) match(ListLexer.NAME);
		else if ( lookahead.type == ListLexer.LBRACK) list();
		else throw new Error("expecting name or list; found " + lookahead);
		
	}
}
