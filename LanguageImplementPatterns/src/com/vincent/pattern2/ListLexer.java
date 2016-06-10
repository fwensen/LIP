package com.vincent.pattern2;

public class ListLexer extends Lexer{

	/**
	 * �ʷ�����
	 * 
	 */
	public static int NAME = 2; //������ֱ�־��
	public static int COMMA = 3; //����
	public static int LBRACK = 4; //������
	public static int RBRACK = 5; //������
	public static String[] tokenNames = 
		{"n/a", "<EOF>", "NAME", "COMMA", "LBRACK", "RBRACK"};
	
	public ListLexer(String input) {
		super(input);
	}
	
	boolean isLETTER() {
		return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
	}

	@Override
	public Token nextToken() {
		while (c != EOF) {
			switch (c) {
				case ' ' : case '\t' : case '\n': case '\r': 
					WS(); continue;
				case ',': consume(); return new Token(COMMA, ",");
				case '[': consume(); return new Token(LBRACK, "[");
				case ']': consume(); return new Token(RBRACK, "]");
				default:
					/**
					 * �����ǰ�����ַ������������ϼ��֣���Ӧ���ռ��ݴ����н���������ĸ
					 */
					if (isLETTER()) return NAME();
					throw new Error("invalid character: " + c);
			}
			
		}
		return new Token(EOF_TYPE, "<EOF>");
	}

	@Override
	public String getTokenName(int tokenType) {
		return null;
	}
	
	/**
	 * NAME: ('a','b'...'z'|'A','B',...'Z') NAME��һ��������ĸ���
	 * @return
	 */
	Token NAME() {
		StringBuilder buf = new StringBuilder();
		do {buf.append(c); consume(); } while ( isLETTER() );
		return new Token(NAME, buf.toString());
	}
	/**
	 * �ո�, '\t', '\n'....
	 */
	void WS() {
		while (c == ' ' || c == '\t' || c == '\n' || c == '\r') 
			consume();
	}
	
}
