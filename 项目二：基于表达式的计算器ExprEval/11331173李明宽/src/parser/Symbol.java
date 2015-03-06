package parser;

/**
 * <p>
 * 这是符号类， 里边包含了接下来的实现表达式计算器中需要到的所有符号，用于在词法分析以及语法分析中使用
 * </p>
 * 
 * @author limkuan
 * 
 */
public class Symbol {

	public static final int DECIMAL = 0;
	public static final int PLUS = 1;
	public static final int MINUS = 2;
	public static final int MULTIPLY = 3;
	public static final int DIVISION = 4;
	public static final int INVOLUTION = 5;
	public static final int NEGATIVE = 6;
	public static final int LEFT_BRACKET = 7;
	public static final int RIGHT_BRACKET = 8;
	public static final int QUESTION_MARK = 9;
	public static final int COLON = 10;
	public static final int FUNC_SIN = 11;
	public static final int FUNC_COS = 12;
	public static final int FUNC_MAX = 13;
	public static final int FUNC_MIN = 14;
	public static final int COMMA = 15;
	public static final int BOOL_TRUE = 16;
	public static final int BOOL_FALSE = 17;
	public static final int COM_LARGER = 18;
	public static final int COM_EQLARGER = 19;
	public static final int COM_SMALLER = 20;
	public static final int COM_EQSMALLER = 21;
	public static final int COM_EQUAL = 22;
	public static final int COM_NOEQUAL = 23;
	public static final int LOGIC_AND = 24;
	public static final int LOGIC_OR = 25;
	public static final int LOGIC_NOT = 26;
	public static final int EOF = 27;

}
