package com.vincent.pattern4;

import com.vincent.pattern2.Lexer;
import com.vincent.pattern2.Token;

/**
 * 
 * @author vincent
 *
 */
public class Parser {

	Lexer input;   //������ʷ���Ԫ����Դ
	Token[] lookahead; //���λ�����
	int k;      //��ǰ�����ŵĸ���
	int p = 0; //���λ�������װ����һ���ʷ���Ԫ��λ��
	
	public Parser(Lexer input, int k) {
		this.input = input;
		this.k = k;
		lookahead = new Token[k];
		for (int i = 1; i <= k; i++) consume();
	}
	
	public void consume() {
		lookahead[p] = input.nextToken();
		p = (p + 1) % k;
	}
	
	
	
}
