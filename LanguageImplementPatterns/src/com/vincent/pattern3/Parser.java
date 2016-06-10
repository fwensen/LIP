package com.vincent.pattern3;

import com.vincent.pattern2.Lexer;
import com.vincent.pattern2.Token;

/**
 * 
 * @author vincent
 *
 */
public abstract class Parser {
	
	Lexer input;      //����Ĵʷ���Ԫ
	Token lookahead; //��ǰ����ǰ������
	
	public Parser(Lexer input) {
		this.input = input;
		lookahead = input.nextToken();
	}
	
	/**
	 * �����ǰ���ʷ�������ƥ��x����ô���Բ����أ����򱨴�
	 * @param x
	 */
	public void match (int x) {
		if (lookahead.type == x) consume();
		else throw new Error("expecting " + input.getTokenName(x) +
				"; found " + lookahead);
	}
	/**
	 * ȡ����һ���ʷ���Ԫ
	 */
	public void consume() {
		lookahead = input.nextToken();
	}
	
}
