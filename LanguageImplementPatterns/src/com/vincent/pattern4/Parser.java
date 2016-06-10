package com.vincent.pattern4;

import com.vincent.pattern2.Lexer;
import com.vincent.pattern2.Token;

/**
 * 
 * @author vincent
 *
 */
public class Parser {

	Lexer input;   //待处理词法单元的来源
	Token[] lookahead; //环形缓冲区
	int k;      //向前看符号的个数
	int p = 0; //环形缓冲区中装填下一个词法单元的位置
	
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
