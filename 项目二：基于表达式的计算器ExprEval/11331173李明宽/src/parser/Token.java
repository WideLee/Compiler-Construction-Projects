package parser;

/**
 * <p>
 * Token类生成一个Token词法单元，里面包含了这个单元的符号类型以及用字符串
 * <code>String</code>形式表示的符号
 * </p>
 * 
 * @author limkuan
 * 
 */
public class Token {

	public int symbol;
	public String valueString;

	/**
	 * <p>
	 * Token的构造函数
	 * </p>
	 * 
	 * @param symbol
	 *            这个Token中包含的符号类型
	 * @param str
	 *            用字符串形式表示符号
	 */
	public Token(int symbol, String str) {
		this.symbol = symbol;
		this.valueString = str;
	}
}
