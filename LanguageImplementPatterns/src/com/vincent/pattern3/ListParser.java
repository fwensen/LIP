package com.vincent.pattern3;

import com.vincent.pattern2.Lexer;
import com.vincent.pattern2.ListLexer;

/**
 * �﷨�����������б��б�����
 * @author vincent
 *
 */
public class ListParser extends Parser{

	public ListParser(Lexer input) {
		super(input);
	}
	
	/**
	 * list: '[' elements ']] ; ƥ�䷽����
	 */
	public void list() {
		match(ListLexer.LBRACK); //����'['
		elements();              //����elements
		match(ListLexer.RBRACK); //����']'
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
	 * element: name | list; һ��elementҪô��NAME��Ҫô��Ƕ�׵�list
	 */
	void element() {
		
		if(lookahead.type == ListLexer.NAME) match(ListLexer.NAME);
		else if ( lookahead.type == ListLexer.LBRACK) list();
		else throw new Error("expecting name or list; found " + lookahead);
		
	}
}
