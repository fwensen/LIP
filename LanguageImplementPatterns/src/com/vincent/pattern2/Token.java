package com.vincent.pattern2;

/**
 * 词法单元类，包含词法类型和字符串
 * @author vincent
 *
 */
public class Token {

	public int type;
	public String text;
	public Token(int type, String text) {
		this.type = type;
		this.text = text;
	}
	
	public String toString() {
		String tname = ListLexer.tokenNames[type];
		return "<'" + text + "'," + tname + ">";
	}
	
}
