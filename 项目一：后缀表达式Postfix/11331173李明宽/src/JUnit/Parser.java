import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p>
 * This is a Parser which can change expression from infix to postfix, the
 * expression doesn't have '(', ')' , and its operator of expression only has
 * '+' and '-', and operand of expression is a digit number which means '0'-'9'.
 * </p>
 * <p>
 * If the input expression is wrong, it can check where has problems and report
 * the type of error like syntax error and lexcial error
 * </p>
 * 
 * @see ExceptionManager
 * @author Mingkuan Lee
 * 
 */
public class Parser {
	int lookahead;
	static int index;
	private String infixString;
	public ExceptionManager exceptionManager;

	/**
	 * <p>
	 * Construct a parser which has exception manager, and read the infix
	 * expression from standard input stream.
	 * </p>
	 * 
	 * @throws IOException
	 */
	public Parser() throws IOException {

		exceptionManager = new ExceptionManager();
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		infixString = bReader.readLine();
		infixString += '\0';
		index = 0;
		lookahead = infixString.charAt(index);
	}

	/**
	 * <p>
	 * If the expression is correct, transfer it to postfix expression,
	 * otherwise it shows the error message.
	 * </p>
	 * 
	 * @return If the expression is correct, return string is the postfix
	 *         expression for input expression. And if the expression is
	 *         illegal, it will return position of error and type of error.
	 * @throws IOException
	 */
	public String expr() throws IOException {
		if (lookahead == '\0') {
			exceptionManager.addError(ExceptionManager.SYNTAX_ERROR_EMPTY, lookahead);
			exceptionManager.addChar('1');
			exceptionManager.addChar('1');
			exceptionManager.addChar('+');
			return exceptionManager.getString();
		}
		
		
		term();
		if (lookahead == '\0') {
			exceptionManager.addError(ExceptionManager.SYNTAX_ERROR_LACK_OPERATOR, ' ');
		}
		while (true) {
			if (lookahead == '+') {
				match('+');
				if (term()) {
					exceptionManager.addChar('+');
				}
			} else if (lookahead == '-') {
				match('-');
				if (term()) {
					exceptionManager.addChar('-');
				}
			} else if (Character.isDigit((char) lookahead)) {
				exceptionManager.addError(ExceptionManager.SYNTAX_ERROR_LACK_OPERATOR, lookahead);
				match(lookahead);
			} else if (lookahead == '\0') {
				break;
			} else {
				exceptionManager.addError(ExceptionManager.LEXICAL_ERROR, lookahead);
				match(lookahead);
			}
		}

		return exceptionManager.getString();
	}

	/**
	 * <p>
	 * If the character after operator is digit, match it and move to next,
	 * otherwise show the error message.
	 * </p>
	 * 
	 * @return Whether the character after operator is digit.
	 * @throws IOException
	 */
	public boolean term() throws IOException {
		if (Character.isDigit((char) lookahead)) {
			exceptionManager.addChar((char) lookahead);
			match(lookahead);
			return true;
		} else if (lookahead == '+' || lookahead == '-') {
			exceptionManager.addError(ExceptionManager.SYNTAX_ERROR_LACK_OPERAND, lookahead);
			return false;
		} else if (lookahead == '\0') {
			exceptionManager.addChar('1');
			exceptionManager.addCorrectString('+');
			exceptionManager.addError(ExceptionManager.SYNTAX_ERROR_LACK_OPERAND, ' ');
			return false;
		} else {
			exceptionManager.addChar('1');
			exceptionManager.addCorrectString('+');
			exceptionManager.addError(ExceptionManager.LEXICAL_ERROR, lookahead);
			match(lookahead);
			return false;
		}
	}

	/**
	 * <p>
	 * Match a character and move to next character to process
	 * </p>
	 * 
	 * @param t
	 *            the character which lookahead must equal to.
	 * @throws IOException
	 */
	public void match(int t) throws IOException {
		if (lookahead == t)
			lookahead = infixString.charAt(++index);
		else
			exceptionManager.addError(ExceptionManager.UNKNOW_ERROR, lookahead);
	}
}
