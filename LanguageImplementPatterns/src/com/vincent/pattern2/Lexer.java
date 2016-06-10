package com.vincent.pattern2;

/**
 * 获取词法单元
 * @author vincent
 *
 */
public abstract class Lexer {

	public static final char EOF = (char) - 1; // EOF字符
	public static final int EOF_TYPE = 1; //EOF词法类型
	
	String input; //输入字符串
	int p = 0;    //当前输入字符串的下标
	char c;       //当前字符
	
	/**
	 * 记住输入字符串，并将第一个字符赋给c
	 * @param input
	 */
	public Lexer(String input) {
		this.input = input;
		c = input.charAt(p);
	}
	
	/**
	 * 向前移动一个字符；检测输入是否结束
	 */
	public void consume() {
		p++;
		if (p >= input.length() ) c = EOF;
		else c = input.charAt(p);
	}
	/**
	 * 确保x是输入流中的下一个字符
	 * @param x
	 */
	public void match(char x) {
		if (c == x) consume();
		else throw new Error("expecting "+x+"; found " + c);
	}
	
	public abstract Token nextToken();
	public abstract String getTokenName(int tokenType);
}
