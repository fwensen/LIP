package com.vincent.pattern2;

/**
 * ��ȡ�ʷ���Ԫ
 * @author vincent
 *
 */
public abstract class Lexer {

	public static final char EOF = (char) - 1; // EOF�ַ�
	public static final int EOF_TYPE = 1; //EOF�ʷ�����
	
	String input; //�����ַ���
	int p = 0;    //��ǰ�����ַ������±�
	char c;       //��ǰ�ַ�
	
	/**
	 * ��ס�����ַ�����������һ���ַ�����c
	 * @param input
	 */
	public Lexer(String input) {
		this.input = input;
		c = input.charAt(p);
	}
	
	/**
	 * ��ǰ�ƶ�һ���ַ�����������Ƿ����
	 */
	public void consume() {
		p++;
		if (p >= input.length() ) c = EOF;
		else c = input.charAt(p);
	}
	/**
	 * ȷ��x���������е���һ���ַ�
	 * @param x
	 */
	public void match(char x) {
		if (c == x) consume();
		else throw new Error("expecting "+x+"; found " + c);
	}
	
	public abstract Token nextToken();
	public abstract String getTokenName(int tokenType);
}
