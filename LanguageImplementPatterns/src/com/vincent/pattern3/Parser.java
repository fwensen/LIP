package com.vincent.pattern3;

import com.vincent.pattern2.Lexer;
import com.vincent.pattern2.Token;

/**
 * 
 * @author vincent
 *
 */
public abstract class Parser {
	
	Lexer input;      //输入的词法单元
	Token lookahead; //当前的向前看符号
	
	public Parser(Lexer input) {
		this.input = input;
		lookahead = input.nextToken();
	}
	
	/**
	 * 如果向前看词法类型能匹配x，那么忽略并返回，否则报错
	 * @param x
	 */
	public void match (int x) {
		if (lookahead.type == x) consume();
		else throw new Error("expecting " + input.getTokenName(x) +
				"; found " + lookahead);
	}
	/**
	 * 取得下一个词法单元
	 */
	public void consume() {
		lookahead = input.nextToken();
	}
	
}
