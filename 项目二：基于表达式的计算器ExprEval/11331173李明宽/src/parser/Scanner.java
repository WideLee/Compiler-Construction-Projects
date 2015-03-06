package parser;

import exceptions.EmptyExpressionException;
import exceptions.IllegalDecimalException;
import exceptions.IllegalIdentifierException;
import exceptions.IllegalSymbolException;

/**
 * <p>
 * Scanner类，主要功能把表达式字符串变成一个个词法单元Token，可以在语法分析器里调用
 * <code>getNextToken</code>得到下一个词法单元
 * </p>
 * 
 * @author limkuan
 * 
 */
public class Scanner {

	private String inputString;
	private int index;

	/**
	 * <p>
	 * Scanner类的构造函数
	 * </p>
	 * 
	 * @param inputStr
	 *            ：输入的表达式字符串
	 */
	public Scanner(String inputStr) {
		inputStr = inputStr.toLowerCase();
		inputString = inputStr;
		index = 0;
	}

	/**
	 * <p>
	 * 从上一次扫描结束的位置开始，获得下一个词法单元Token
	 * </p>
	 * 
	 * @return 下一个词法单元，用于语法分析
	 * @throws EmptyExpressionException
	 *             ：当输入表达式为空的时候抛出该异常
	 * @throws IllegalDecimalException
	 *             ：当遇到非法的双精度浮点数的时候抛出
	 * @throws IllegalIdentifierException
	 *             ：遇到非法的标识符（合法的标识符有max,min,cos,sin）的时候抛出
	 * @throws IllegalSymbolException
	 *             ： 当遇到不在符号集的符号的时候抛出
	 */
	public Token getNextToken() throws EmptyExpressionException,
			IllegalDecimalException, IllegalIdentifierException,
			IllegalSymbolException {
		String valueString = new String();
		if (inputString.replaceAll(" ", "").length() == 0) {
			throw new EmptyExpressionException();
		} else if (index == inputString.length()) {
			// 到达表达式字符串结尾，返回EOF结束标志
			return new Token(Symbol.EOF, "");
		} else {
			if (Character.isDigit(inputString.charAt(index))) {
				valueString += inputString.charAt(index++);
				while (index < inputString.length()
						&& (Character.isDigit(inputString.charAt(index))
								|| inputString.charAt(index) == 'e'
								|| inputString.charAt(index) == '.' || ((inputString
								.charAt(index) == '+' || inputString
								.charAt(index) == '-') && inputString
								.charAt(index - 1) == 'e'))) {
					valueString += inputString.charAt(index++);
				}
				// 判断读取到的数值型字符串集是不是一个合法的浮点数
				if (valueString.matches("[0-9]+(.[0-9]+)?(e[+-]?[0-9]+)?")) {
					return new Token(Symbol.DECIMAL, valueString);
				} else {
					throw new IllegalDecimalException();
				}
			} else if (inputString.charAt(index) == '+') {
				valueString += inputString.charAt(index++);
				return new Token(Symbol.PLUS, valueString);
			} else if (inputString.charAt(index) == '-') {
				// 如果遇到'-'，判断是取负符号还是减号
				// 判断的方法是减号前一个Token只能是右括号')'或者数字，其余的都是取负运算
				int noneSpace = index - 1;
				while (inputString.charAt(noneSpace) == ' ') {
					noneSpace--;
				}
				if (index != 0
						&& (Character.isDigit(inputString.charAt(noneSpace)) || inputString
								.charAt(noneSpace) == ')')) {
					valueString += inputString.charAt(index++);
					return new Token(Symbol.MINUS, valueString);
				} else {
					valueString += inputString.charAt(index++);
					return new Token(Symbol.NEGATIVE, valueString);
				}
			} else if (inputString.charAt(index) == '*') {
				valueString += inputString.charAt(index++);
				return new Token(Symbol.MULTIPLY, valueString);
			} else if (inputString.charAt(index) == '/') {
				valueString += inputString.charAt(index++);
				return new Token(Symbol.DIVISION, valueString);
			} else if (inputString.charAt(index) == '^') {
				valueString += inputString.charAt(index++);
				return new Token(Symbol.INVOLUTION, valueString);
			} else if (inputString.charAt(index) == '(') {
				valueString += inputString.charAt(index++);
				return new Token(Symbol.LEFT_BRACKET, valueString);
			} else if (inputString.charAt(index) == ')') {
				valueString += inputString.charAt(index++);
				return new Token(Symbol.RIGHT_BRACKET, valueString);
			} else if (inputString.charAt(index) == '?') {
				valueString += inputString.charAt(index++);
				return new Token(Symbol.QUESTION_MARK, valueString);
			} else if (inputString.charAt(index) == ':') {
				valueString += inputString.charAt(index++);
				return new Token(Symbol.COLON, valueString);
			} else if (inputString.charAt(index) == 's') {
				valueString += inputString.charAt(index++);
				if (inputString.charAt(index) == 'i'
						&& inputString.charAt(index + 1) == 'n') {
					valueString += inputString.charAt(index++);
					valueString += inputString.charAt(index++);
					return new Token(Symbol.FUNC_SIN, valueString);
				} else {
					throw new IllegalIdentifierException();
				}
			} else if (inputString.charAt(index) == 'c') {
				valueString += inputString.charAt(index++);
				if (inputString.charAt(index) == 'o'
						&& inputString.charAt(index + 1) == 's') {
					valueString += inputString.charAt(index++);
					valueString += inputString.charAt(index++);
					return new Token(Symbol.FUNC_COS, valueString);
				} else {
					throw new IllegalIdentifierException();
				}
			} else if (inputString.charAt(index) == 'm') {
				valueString += inputString.charAt(index++);
				if (inputString.charAt(index) == 'a'
						&& inputString.charAt(index + 1) == 'x') {
					valueString += inputString.charAt(index++);
					valueString += inputString.charAt(index++);
					return new Token(Symbol.FUNC_MAX, valueString);
				} else if (inputString.charAt(index) == 'i'
						&& inputString.charAt(index + 1) == 'n') {
					valueString += inputString.charAt(index++);
					valueString += inputString.charAt(index++);
					return new Token(Symbol.FUNC_MIN, valueString);
				} else {
					throw new IllegalIdentifierException();
				}
			} else if (inputString.charAt(index) == ',') {
				valueString += inputString.charAt(index++);
				return new Token(Symbol.COMMA, valueString);
			} else if (inputString.charAt(index) == '?') {
				valueString += inputString.charAt(index++);
				return new Token(Symbol.QUESTION_MARK, valueString);
			} else if (inputString.charAt(index) == 't') {
				valueString += inputString.charAt(index++);
				if (inputString.charAt(index) == 'r'
						&& inputString.charAt(index + 1) == 'u'
						&& inputString.charAt(index + 2) == 'e') {
					valueString += inputString.charAt(index++);
					valueString += inputString.charAt(index++);
					valueString += inputString.charAt(index++);
					return new Token(Symbol.BOOL_TRUE, valueString);
				} else {
					throw new IllegalIdentifierException();
				}
			} else if (inputString.charAt(index) == 'f') {
				valueString += inputString.charAt(index++);
				if (inputString.charAt(index) == 'a'
						&& inputString.charAt(index + 1) == 'l'
						&& inputString.charAt(index + 2) == 's'
						&& inputString.charAt(index + 3) == 'e') {
					valueString += inputString.charAt(index++);
					valueString += inputString.charAt(index++);
					valueString += inputString.charAt(index++);
					valueString += inputString.charAt(index++);

					return new Token(Symbol.BOOL_FALSE, valueString);
				} else {
					throw new IllegalIdentifierException();
				}
			} else if (inputString.charAt(index) == '>') {
				valueString += inputString.charAt(index++);
				if (inputString.charAt(index) == '=') {
					valueString += inputString.charAt(index++);
					return new Token(Symbol.COM_EQLARGER, valueString);
				} else {
					return new Token(Symbol.COM_LARGER, valueString);
				}
			} else if (inputString.charAt(index) == '<') {
				valueString += inputString.charAt(index++);
				if (inputString.charAt(index) == '=') {
					valueString += inputString.charAt(index++);
					return new Token(Symbol.COM_EQSMALLER, valueString);
				} else if (inputString.charAt(index) == '>') {
					valueString += inputString.charAt(index++);
					return new Token(Symbol.COM_NOEQUAL, valueString);
				} else {
					return new Token(Symbol.COM_SMALLER, valueString);
				}
			} else if (inputString.charAt(index) == '=') {
				valueString += inputString.charAt(index++);
				return new Token(Symbol.COM_EQUAL, valueString);
			} else if (inputString.charAt(index) == '&') {
				valueString += inputString.charAt(index++);
				return new Token(Symbol.LOGIC_AND, valueString);
			} else if (inputString.charAt(index) == '|') {
				valueString += inputString.charAt(index++);
				return new Token(Symbol.LOGIC_OR, valueString);
			} else if (inputString.charAt(index) == '!') {
				valueString += inputString.charAt(index++);
				return new Token(Symbol.LOGIC_NOT, valueString);
			} else if (inputString.charAt(index) == ' ') {
				// 如果遇到空格，忽略这个空格并继续读下一个Token
				index++;
				return this.getNextToken();
			} else if (Character.isLetter(inputString.charAt(index))) {
				throw new IllegalIdentifierException();
			} else {
				throw new IllegalSymbolException();
			}
		}
	}
}
