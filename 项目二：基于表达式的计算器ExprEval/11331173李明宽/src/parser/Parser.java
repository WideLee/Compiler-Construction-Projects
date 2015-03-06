package parser;

import java.util.Stack;

import exceptions.DividedByZeroException;
import exceptions.EmptyExpressionException;
import exceptions.FunctionCallException;
import exceptions.IllegalDecimalException;
import exceptions.IllegalIdentifierException;
import exceptions.IllegalSymbolException;
import exceptions.MissingLeftParenthesisException;
import exceptions.MissingOperandException;
import exceptions.MissingOperatorException;
import exceptions.MissingRightParenthesisException;
import exceptions.TrinaryOperationException;
import exceptions.TypeMismatchedException;

/**
 * <p>
 * 适合这个表达式字符串求值的语法分析器，使用OPP算符优先算法
 * </p>
 * 
 * @author limkuan
 * 
 */
public class Parser {

	/**
	 * <p>
	 * 算符优先OPP表
	 * </p>
	 * 
	 * <p>
	 * 一共有17个符号，按顺序（从上到下）分别是
	 * <code>"+/-", "*\/", "^", "-", "(",
	 * ")", "?", ":", "&", "|", "!", "Func", ",", "Com",
	 * "Dec", "Bool", "$"</code>
	 * </p>
	 * 
	 * <p>
	 * 表中的数据分别表示：<br>
	 * 0——接收状态<br />
	 * 1——移入操作<br />
	 * 2——进行二元运算<br />
	 * 3——进行单目运算（取负）<br />
	 * 4——进行括号的运算（包括函数）<br />
	 * 5——进行三目运算<br />
	 * 6——进行与或运算<br />
	 * 7——进行布尔运算（取非）<br />
	 * 8——进行比较运算<br />
	 * 9——进行操作数压栈<br />
	 * -1——缺少运算符异常<br />
	 * -2——类型不匹配异常<br />
	 * -3——三目运算符异常<br />
	 * -4——缺少右括号异常<br />
	 * -5——缺少运算符异常（同-1，写的时候重复了，修改太麻烦("▔□▔) ）<br />
	 * -6——函数语法形式错误<br />
	 * -7——未知错误<br />
	 * </p>
	 */
	public static final int OPP_TABLE[][] = {
			{ 2, 1, 1, 1, 1, 2, 2, 2, 2, 2, -1, 1, 2, 2, 1, -2, 2 },
			{ 2, 2, 1, 1, 1, 2, 2, 2, 2, 2, -1, 1, 2, 2, 1, -2, 2 },
			{ 2, 2, 1, 1, 1, 2, 2, 2, 2, 2, -1, 1, 2, 2, 1, -2, 2 },
			{ 3, 3, 3, 1, 1, 3, 3, 3, 3, 3, -1, 1, 3, 3, 1, -2, 3 },
			{ 1, 1, 1, 1, 1, 1, 1, -3, 1, 1, 1, 1, 1, 1, 1, 1, -4 },
			{ 4, 4, 4, -5, -5, 4, 4, 4, 4, 4, -5, -5, 4, 4, -5, -5, 4 },
			{ 1, 1, 1, 1, 1, -3, 1, 1, 1, 1, 1, 1, -3, 1, 1, 1, -3 },
			{ 1, 1, 1, 1, 1, 5, 1, 1, 1, 1, 1, 1, -5, 1, 1, 1, 5 },
			{ 1, 1, 1, 1, 1, 6, 6, 6, 6, 6, 6, 1, 6, 1, 1, 1, 6 },
			{ 1, 1, 1, 1, 1, 6, 6, 6, 1, 6, 6, 1, 6, 1, 1, 1, 6 },
			{ 1, 1, 1, 1, 1, 7, 7, 7, 7, 7, 1, -5, -2, 1, -2, 1, 7 },
			{ -6, -6, -6, -6, 1, -6, -6, -6, -6, -6, -6, -6, -6, -6, -6, -6, -6 },
			{ 1, 1, 1, 1, 1, 1, 1, -3, 1, 1, 1, 1, 1, 1, 1, 1, -6 },
			{ 1, 1, 1, 1, 1, 8, 8, 8, 8, 8, 8, 1, 8, 8, 1, -2, 8 },
			{ 9, 9, 9, 9, -5, 9, 9, 9, 9, 9, -5, -5, 9, 9, -5, -5, 9 },
			{ -2, -2, -2, -2, -5, 9, 9, -2, 9, 9, -5, -5, -2, -2, -5, -5, 9 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -7, 1, 1, 1, 0 } };
	public static final String operators[] = { "+/-", "*\\/", "^", "-", "(",
			")", "?", ":", "&", "|", "!", "Func", ",", "Com", "Dec", "Bool",
			"$" };

	/**
	 * 存储运算符的栈
	 */
	public Stack<Token> opStack = new Stack<>();
	/**
	 * 操作数运算符的栈
	 */
	public Stack<Token> valStack = new Stack<>();

	private Scanner scanner;
	private Token nextToken;
	private Token topToken;
	/**
	 * 存放语法分析结束后得到的表达式结果
	 */
	public double result;

	/**
	 * <p>
	 * Parser类的构造函数，里面实例化了一个Scanner词法分析器，然后把字符串终结符$放入符号栈
	 * </p>
	 * 
	 * @param inputStr
	 *            ：要进行求值的表达式字符串
	 */
	public Parser(String inputStr) {
		scanner = new Scanner(inputStr);
		opStack.add(new Token(Symbol.EOF, "$"));
	}

	/**
	 * <p>
	 * 进行规约操作，按照给定的type
	 * </p>
	 * 
	 * @param type
	 *            ：要进行怎样的规约（使用哪个文法推到式规约）
	 * @see Parser#OPP_TABLE
	 * @throws DividedByZeroException
	 *             ：除数为零错误
	 * @throws IllegalSymbolException
	 *             ：非法的符号错误
	 * @throws TypeMismatchedException
	 *             ：类型不匹配错误
	 * @throws MissingLeftParenthesisException
	 *             ：缺少左括号错误
	 * @throws IllegalIdentifierException
	 *             ： 非法的标识符错误
	 * @throws FunctionCallException
	 *             ： 预定义函数调用的语法形式错误
	 * @throws MissingOperandException
	 *             ：缺少操作数错误
	 */
	public void reduce(int type) throws DividedByZeroException,
			IllegalSymbolException, TypeMismatchedException,
			MissingLeftParenthesisException, IllegalIdentifierException,
			FunctionCallException, MissingOperandException {
		switch (type) {
		case 2:
			binaryOperation();
			break;
		case 3:
			negativeOperation();
			break;
		case 4:
			bracketOperation();
			break;
		case 5:
			ternaryOperation();
			break;
		case 6:
			andOrOperation();
			break;
		case 7:
			boolOperation();
			break;
		case 8:
			compareOperation();
			break;
		case 9:
			pushValStack();
			break;
		default:
			break;
		}
	}

	/**
	 * <p>
	 * 进行移入操作，把当前的Token放入符号栈，并往前读一个Token
	 * </p>
	 * 
	 * @param token
	 *            ：要压入符号栈中的Token
	 * @throws EmptyExpressionException
	 *             ：表达式为空错误
	 * @throws IllegalDecimalException
	 *             ： 非法的数值常量错误
	 * @throws IllegalIdentifierException
	 *             ：非法的标识符错误
	 * @throws IllegalSymbolException
	 *             ：非法的符号错误
	 */
	public void shift(Token token) throws EmptyExpressionException,
			IllegalDecimalException, IllegalIdentifierException,
			IllegalSymbolException {
		if (token.symbol != Symbol.EOF) {
			opStack.push(token);
			nextToken = scanner.getNextToken();
		}
	}

	/**
	 * <p>
	 * 获得给定Token的符号对应OPP表中的序号
	 * </p>
	 * 
	 * @see Parser#OPP_TABLE
	 * @param token
	 *            : 要查询的序号的Token
	 * @return 参数中Token的Symbol对应的OPP表中的index序号
	 * @throws IllegalSymbolException
	 *             ： 非法的符号错误
	 */
	public int getTokenIndex(Token token) throws IllegalSymbolException {
		if (token.symbol == Symbol.PLUS || token.symbol == Symbol.MINUS) {
			return 0;
		} else if (token.symbol == Symbol.MULTIPLY
				|| token.symbol == Symbol.DIVISION) {
			return 1;
		} else if (token.symbol == Symbol.INVOLUTION) {
			return 2;
		} else if (token.symbol == Symbol.NEGATIVE) {
			return 3;
		} else if (token.symbol == Symbol.LEFT_BRACKET) {
			return 4;
		} else if (token.symbol == Symbol.RIGHT_BRACKET) {
			return 5;
		} else if (token.symbol == Symbol.QUESTION_MARK) {
			return 6;
		} else if (token.symbol == Symbol.COLON) {
			return 7;
		} else if (token.symbol == Symbol.LOGIC_AND) {
			return 8;
		} else if (token.symbol == Symbol.LOGIC_OR) {
			return 9;
		} else if (token.symbol == Symbol.LOGIC_NOT) {
			return 10;
		} else if (token.symbol == Symbol.FUNC_SIN
				|| token.symbol == Symbol.FUNC_COS
				|| token.symbol == Symbol.FUNC_MAX
				|| token.symbol == Symbol.FUNC_MIN) {
			return 11;
		} else if (token.symbol == Symbol.COMMA) {
			return 12;
		} else if (token.symbol == Symbol.COM_LARGER
				|| token.symbol == Symbol.COM_EQLARGER
				|| token.symbol == Symbol.COM_SMALLER
				|| token.symbol == Symbol.COM_EQSMALLER
				|| token.symbol == Symbol.COM_EQUAL
				|| token.symbol == Symbol.COM_NOEQUAL) {
			return 13;
		} else if (token.symbol == Symbol.DECIMAL) {
			return 14;
		} else if (token.symbol == Symbol.BOOL_TRUE
				|| token.symbol == Symbol.BOOL_FALSE) {
			return 15;
		} else if (token.symbol == Symbol.EOF) {
			return 16;
		} else {
			throw new IllegalSymbolException();
		}
	}

	/**
	 * <p>
	 * 对给定的表达式字符串进行语法分析，结束后把得到的结果赋予result变量
	 * </p>
	 * 
	 * @throws IllegalDecimalException
	 *             ：非法的数值常量错误
	 * @throws IllegalIdentifierException
	 *             ：非法的标识符错误
	 * @throws IllegalSymbolException
	 *             ：非法的符号错误
	 * @throws TypeMismatchedException
	 *             ：类型不匹配错误
	 * @throws DividedByZeroException
	 *             ：被零除错误
	 * @throws EmptyExpressionException
	 *             ：空表达式错误
	 * @throws MissingLeftParenthesisException
	 *             ：缺少左括号错误
	 * @throws FunctionCallException
	 *             ：预定义函数调用的语法形式错误
	 * @throws MissingOperatorException
	 *             ：缺少运算符错误
	 * @throws TrinaryOperationException
	 *             ：三目运算的语法形式错误
	 * @throws MissingRightParenthesisException
	 *             :缺少右括号错误
	 * @throws MissingOperandException
	 *             ：缺少操作数错误
	 */
	public void parser() throws IllegalDecimalException,
			IllegalIdentifierException, IllegalSymbolException,
			TypeMismatchedException, DividedByZeroException,
			EmptyExpressionException, MissingLeftParenthesisException,
			FunctionCallException, MissingOperatorException,
			TrinaryOperationException, MissingRightParenthesisException,
			MissingOperandException {
		nextToken = scanner.getNextToken();
		while (true) {
			topToken = opStack.peek();
			int action = OPP_TABLE[getTokenIndex(topToken)][getTokenIndex(nextToken)];
			printState(action);
			if (action == 0) {
				break;
			} else if (action == 1) {
				shift(nextToken);
			} else if (action == 2 || action == 3 || action == 4 || action == 5
					|| action == 6 || action == 7 || action == 8 || action == 9) {
				reduce(action);
			} else if (action == -1) {
				throw new MissingOperatorException();
			} else if (action == -2) {
				throw new TypeMismatchedException();
			} else if (action == -3) {
				throw new TrinaryOperationException();
			} else if (action == -4) {
				throw new MissingRightParenthesisException();
			} else if (action == -5) {
				throw new MissingOperatorException();
			} else if (action == -6) {
				throw new FunctionCallException();
			} else if (action == -7) {
				throw new FunctionCallException();
			}
		}
		if (valStack.isEmpty()) {
			throw new MissingOperandException();
		} else if (valStack.peek().symbol == Symbol.DECIMAL) {
			result = Double.parseDouble(valStack.peek().valueString);
		} else {
			throw new TypeMismatchedException();
		}
	}

	/**
	 * <p>
	 * 进行二元运算符规约操作，其中涉及到的运算符有"+-*\/^"
	 * </p>
	 * 
	 * @throws DividedByZeroException
	 *             :被零除错误
	 * @throws TypeMismatchedException
	 *             ：类型不匹配错误
	 * @throws MissingOperandException
	 *             ：缺少操作数错误
	 */
	public void binaryOperation() throws DividedByZeroException,
			TypeMismatchedException, MissingOperandException {
		opStack.pop();
		double value = 0;
		double operand_1 = 0;
		double operand_2 = 0;
		if (valStack.isEmpty()) {
			throw new MissingOperandException();
		} else if (valStack.peek().symbol != Symbol.DECIMAL) {
			throw new TypeMismatchedException();
		} else {
			operand_1 = Double.parseDouble(valStack.pop().valueString);
		}

		if (valStack.isEmpty()) {
			throw new MissingOperandException();
		} else if (valStack.peek().symbol != Symbol.DECIMAL) {
			throw new TypeMismatchedException();
		} else {
			operand_2 = Double.parseDouble(valStack.pop().valueString);
		}
		if (topToken.symbol == Symbol.PLUS) {
			value = operand_2 + operand_1;
		} else if (topToken.symbol == Symbol.MINUS) {
			value = operand_2 - operand_1;
		} else if (topToken.symbol == Symbol.MULTIPLY) {
			value = operand_2 * operand_1;
		} else if (topToken.symbol == Symbol.DIVISION) {
			if (operand_1 == 0) {
				throw new DividedByZeroException();
			} else {
				value = operand_2 / operand_1;
			}
		} else if (topToken.symbol == Symbol.INVOLUTION) {
			value = Math.pow(operand_2, operand_1);
		}
		opStack.push(new Token(Symbol.DECIMAL, Double.toString(value)));
	}

	/**
	 * <p>
	 * 进行取负运算，其中涉及到的运算符有"-"
	 * </p>
	 * 
	 * @throws TypeMismatchedException
	 *             ：类型不匹配错误
	 * @throws MissingOperandException
	 *             ：缺少操作数错误
	 */
	public void negativeOperation() throws TypeMismatchedException,
			MissingOperandException {
		opStack.pop();
		double operand = 0;
		if (valStack.isEmpty()) {
			throw new MissingOperandException();
		} else if (valStack.peek().symbol != Symbol.DECIMAL) {
			throw new TypeMismatchedException();
		} else {
			operand = Double.parseDouble(valStack.pop().valueString);
		}

		opStack.push(new Token(Symbol.DECIMAL, Double.toString(-operand)));
	}

	/**
	 * <p>
	 * 进行括号操作，如果遇到右括号的时候进行运算。如果是往前找到了函数标识符，就进行函数操作，
	 * 没有标识符就直接把括号弹出
	 * </p>
	 * 
	 * @throws TypeMismatchedException
	 *             ：类型不匹配错误
	 * @throws MissingLeftParenthesisException
	 *             ：缺少左括号错误
	 * @throws IllegalIdentifierException
	 *             ：非法标识符错误
	 * @throws FunctionCallException
	 *             ：预定义函数调用的语法形式错误
	 * @throws MissingOperandException
	 *             ：缺少操作数错误
	 */
	public void bracketOperation() throws TypeMismatchedException,
			MissingLeftParenthesisException, IllegalIdentifierException,
			FunctionCallException, MissingOperandException {
		opStack.pop();
		topToken = opStack.pop();
		if (topToken.symbol == Symbol.LEFT_BRACKET) {
			double value = 0;
			double operand = 0;

			if (opStack.peek().symbol == Symbol.FUNC_SIN) {
				opStack.pop();
				if (valStack.isEmpty()) {
					throw new MissingOperandException();
				} else if (valStack.peek().symbol != Symbol.DECIMAL) {
					throw new TypeMismatchedException();
				} else {
					operand = Double.parseDouble(valStack.pop().valueString);
				}
				value = Math.sin(operand);
				opStack.push(new Token(Symbol.DECIMAL, Double.toString(value)));
			} else if (opStack.peek().symbol == Symbol.FUNC_COS) {
				opStack.pop();
				if (valStack.isEmpty()) {
					throw new MissingOperandException();
				} else if (valStack.peek().symbol != Symbol.DECIMAL) {
					throw new TypeMismatchedException();
				} else {
					operand = Double.parseDouble(valStack.pop().valueString);
				}
				value = Math.cos(operand);
				opStack.push(new Token(Symbol.DECIMAL, Double.toString(value)));
			} else if (opStack.peek().symbol == Symbol.FUNC_MAX
					|| opStack.peek().symbol == Symbol.FUNC_MIN) {
				throw new MissingOperandException();
			} else {
				return;
			}

		} else {
			int index = 0;
			for (index = opStack.size() - 1; index >= 0; index--) {
				if (opStack.get(index).symbol == Symbol.LEFT_BRACKET) {
					break;
				}
			}
			if (index == -1) {
				throw new MissingLeftParenthesisException();
			} else if (opStack.get(index - 1).symbol == Symbol.FUNC_MAX) {
				double value = 0;
				if (valStack.isEmpty()) {
					throw new MissingOperandException();
				} else if (valStack.peek().symbol != Symbol.DECIMAL) {
					throw new TypeMismatchedException();
				} else {
					value = Double.parseDouble(valStack.pop().valueString);
				}
				while (topToken.symbol != Symbol.LEFT_BRACKET) {
					topToken = opStack.pop();

					double operand = 0;
					if (valStack.isEmpty()) {
						throw new MissingOperandException();
					} else if (valStack.peek().symbol != Symbol.DECIMAL) {
						throw new TypeMismatchedException();
					} else {
						operand = Double
								.parseDouble(valStack.pop().valueString);
					}
					if (operand > value) {
						value = operand;
					}
				}
				opStack.pop();
				opStack.push(new Token(Symbol.DECIMAL, Double.toString(value)));
			} else if (opStack.get(index - 1).symbol == Symbol.FUNC_MIN) {
				double value = 0;
				if (valStack.isEmpty()) {
					throw new MissingOperandException();
				} else if (valStack.peek().symbol != Symbol.DECIMAL) {
					throw new TypeMismatchedException();
				} else {
					value = Double.parseDouble(valStack.pop().valueString);
				}
				while (topToken.symbol != Symbol.LEFT_BRACKET) {
					topToken = opStack.pop();

					double operand = 0;
					if (valStack.isEmpty()) {
						throw new MissingOperandException();
					} else if (valStack.peek().symbol != Symbol.DECIMAL) {
						throw new TypeMismatchedException();
					} else {
						operand = Double
								.parseDouble(valStack.pop().valueString);
					}
					if (operand < value) {
						value = operand;
					}
				}
				opStack.pop();
				opStack.push(new Token(Symbol.DECIMAL, Double.toString(value)));
			} else if (opStack.get(index - 1).symbol == Symbol.FUNC_SIN
					|| opStack.get(index - 1).symbol == Symbol.FUNC_COS) {
				throw new FunctionCallException();
			} else {
				throw new IllegalIdentifierException();
			}
		}
	}

	/**
	 * <p>
	 * 处理三目运算符操作，处理"?:"这个运算符
	 * </p>
	 * 
	 * @throws TypeMismatchedException
	 *             ：类型不匹配错误
	 * @throws MissingOperandException
	 *             ：缺少操作数的错误
	 */
	public void ternaryOperation() throws TypeMismatchedException,
			MissingOperandException {
		opStack.pop();
		opStack.pop();
		double operand_1 = 0;
		double operand_2 = 0;
		boolean operand_3 = false;

		if (valStack.isEmpty()) {
			throw new MissingOperandException();
		} else if (valStack.peek().symbol != Symbol.DECIMAL) {
			throw new TypeMismatchedException();
		} else {
			operand_1 = Double.parseDouble(valStack.pop().valueString);
		}

		if (valStack.isEmpty()) {
			throw new MissingOperandException();
		} else if (valStack.peek().symbol == Symbol.BOOL_TRUE
				|| valStack.peek().symbol == Symbol.BOOL_FALSE) {
			throw new MissingOperandException();
		} else if (valStack.peek().symbol != Symbol.DECIMAL) {
			throw new TypeMismatchedException();
		} else {
			operand_2 = Double.parseDouble(valStack.pop().valueString);
		}

		if (valStack.isEmpty()) {
			throw new MissingOperandException();
		} else if (!(valStack.peek().symbol == Symbol.BOOL_TRUE || valStack
				.peek().symbol == Symbol.BOOL_FALSE)) {
			throw new TypeMismatchedException();
		} else {
			operand_3 = Boolean.parseBoolean(valStack.pop().valueString);
		}

		double value = operand_3 ? operand_2 : operand_1;
		opStack.push(new Token(Symbol.DECIMAL, Double.toString(value)));
	}

	/**
	 * <p>
	 * 处理与或运算，涉及到的操作符有"&|"
	 * </p>
	 * 
	 * @throws IllegalSymbolException
	 *             ：非法的符号错误
	 * @throws TypeMismatchedException
	 *             ：类型不匹配错误
	 * @throws MissingOperandException
	 */
	public void andOrOperation() throws IllegalSymbolException,
			TypeMismatchedException, MissingOperandException {
		opStack.pop();
		boolean value;
		boolean operand_1 = true;
		boolean operand_2 = true;
		if (valStack.isEmpty()) {
			throw new MissingOperandException();
		} else if (!(valStack.peek().symbol == Symbol.BOOL_TRUE || valStack
				.peek().symbol == Symbol.BOOL_FALSE)) {
			throw new TypeMismatchedException();
		} else {
			operand_1 = Boolean.parseBoolean(valStack.pop().valueString);
		}
		if (valStack.isEmpty()) {
			throw new MissingOperandException();
		} else if (!(valStack.peek().symbol == Symbol.BOOL_TRUE || valStack
				.peek().symbol == Symbol.BOOL_FALSE)) {
			throw new TypeMismatchedException();
		} else {
			operand_2 = Boolean.parseBoolean(valStack.pop().valueString);
		}
		if (topToken.symbol == Symbol.LOGIC_AND) {
			value = operand_2 && operand_1;
		} else if (topToken.symbol == Symbol.LOGIC_OR) {
			value = operand_2 || operand_1;
		} else {
			throw new IllegalSymbolException();
		}
		if (value) {
			opStack.push(new Token(Symbol.BOOL_TRUE, Boolean.toString(value)));
		} else {
			opStack.push(new Token(Symbol.BOOL_FALSE, Boolean.toString(value)));
		}
	}

	/**
	 * <p>
	 * 处理布尔运算，涉及到的操作符有取非操作"!"，是单目运算符
	 * </p>
	 * 
	 * @throws TypeMismatchedException
	 *             ：类型不匹配错误
	 * @throws MissingOperandException
	 *             ：缺少操作数错误
	 */
	public void boolOperation() throws TypeMismatchedException,
			MissingOperandException {
		opStack.pop();
		boolean value;
		boolean operand_1 = true;
		if (valStack.isEmpty()) {
			throw new MissingOperandException();
		} else if (!(valStack.peek().symbol == Symbol.BOOL_TRUE || valStack
				.peek().symbol == Symbol.BOOL_FALSE)) {
			throw new TypeMismatchedException();
		} else {
			operand_1 = Boolean.parseBoolean(valStack.pop().valueString);
		}
		value = !operand_1;
		if (value) {
			opStack.push(new Token(Symbol.BOOL_TRUE, Boolean.toString(value)));
		} else {
			opStack.push(new Token(Symbol.BOOL_FALSE, Boolean.toString(value)));
		}
	}

	/**
	 * <p>
	 * 处理比较运算，涉及到的操作符有"> >= < <= = <>"，属于双目运算
	 * </p>
	 * 
	 * @throws IllegalSymbolException
	 *             ：非法的符号错误
	 * @throws TypeMismatchedException
	 *             ：类型不匹配错误
	 * @throws MissingOperandException
	 *             ：缺失操作数错误
	 */
	public void compareOperation() throws IllegalSymbolException,
			TypeMismatchedException, MissingOperandException {
		opStack.pop();
		boolean value;
		double operand_1 = 0;
		double operand_2 = 0;
		if (valStack.isEmpty()) {
			throw new MissingOperandException();
		} else if (valStack.peek().symbol != Symbol.DECIMAL) {
			throw new TypeMismatchedException();
		} else {
			operand_1 = Double.parseDouble(valStack.pop().valueString);
		}
		if (valStack.isEmpty()) {
			throw new MissingOperandException();
		} else if (valStack.peek().symbol != Symbol.DECIMAL) {
			throw new TypeMismatchedException();
		} else {
			operand_2 = Double.parseDouble(valStack.pop().valueString);
		}
		if (topToken.symbol == Symbol.COM_LARGER) {
			value = (operand_2 > operand_1);
		} else if (topToken.symbol == Symbol.COM_EQLARGER) {
			value = (operand_2 >= operand_1);
		} else if (topToken.symbol == Symbol.COM_SMALLER) {
			value = (operand_2 < operand_1);
		} else if (topToken.symbol == Symbol.COM_EQSMALLER) {
			value = (operand_2 <= operand_1);
		} else if (topToken.symbol == Symbol.COM_EQUAL) {
			value = (operand_2 == operand_1);
		} else if (topToken.symbol == Symbol.COM_NOEQUAL) {
			value = (operand_2 != operand_1);
		} else {
			throw new IllegalSymbolException();
		}
		if (value) {
			opStack.push(new Token(Symbol.BOOL_TRUE, Boolean.toString(value)));
		} else {
			opStack.push(new Token(Symbol.BOOL_FALSE, Boolean.toString(value)));
		}
	}

	/**
	 * <p>
	 * 当栈顶的Token是一个数值类型的时候，把这个Token从符号栈中弹出加入到操作数栈中
	 * </p>
	 */
	public void pushValStack() {
		opStack.pop();
		valStack.push(topToken);
	}

	/**
	 * <p>
	 * 打印出当前的符号栈以及操作数栈，方便调试
	 * </p>
	 */
	public void printState(int action) {
		System.out.print("OpStack: ");
		for (int i = 0; i < opStack.size(); i++) {
			System.out.print(opStack.get(i).valueString + " ");
		}
		System.out.println();
		System.out.print("ValStack: ");
		for (int i = 0; i < valStack.size(); i++) {
			System.out.print(valStack.get(i).valueString + " ");
		}
		System.out.println();
		System.out.println("Action: " + action);
	}
}
