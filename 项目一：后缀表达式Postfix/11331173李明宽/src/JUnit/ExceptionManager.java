import java.security.PublicKey;

/**
 * <p>
 * A exception manager for the class parser.
 * </p>
 * <p>
 * If the expression input for parser is correct, it can get the correct postfix
 * expression for original expression, but if the input expression has problem,
 * it can check it and point to the position of error and the error type for
 * each error.
 * </p>
 * 
 * @see Parser
 * @author Mingkuan Lee
 * 
 */

public class ExceptionManager {

	/**
	 * Error for the input string is empty.
	 */
	public static final int SYNTAX_ERROR_EMPTY = 1;
	/**
	 * Error for the input string lack of operator.
	 */
	public static final int SYNTAX_ERROR_LACK_OPERATOR = 2;
	/**
	 * Error for the input string lack of operator.
	 */
	public static final int SYNTAX_ERROR_LACK_OPERAND = 3;
	/**
	 * Error for the input string has a character isn't in the character set.
	 */
	public static final int LEXICAL_ERROR = 4;
	/**
	 * Other unknown errors!
	 */
	public static final int UNKNOW_ERROR = 5;

	/**
	 * record the infix expression has error
	 */
	public boolean isError;

	private String correctString;
	private String errorString;
	private String errorMessage;

	/**
	 * Construct a Exception manager and initial all variable
	 */
	public ExceptionManager() {
		isError = false;
		correctString = new String();
		errorString = new String();
		errorMessage = new String("It has below errors(from left to right): \n");
	}

	/**
	 * <p>
	 * Get a proper string from exception manager
	 * </p>
	 * 
	 * @return String: if the input expression is correct, it means the postfix
	 *         expression for input, but if the input has some problem, the
	 *         return string is the position of error and demonstrate which
	 *         error type it has.
	 */
	public String getString() {
		if (isError) {
			return errorString + "\n" + errorMessage + "Do you mean the expression \'"
					+ correctString + "\' ?";
		} else {
			return correctString;
		}
	}

	/**
	 * <p>
	 * Add a character which is lookahead to correct string and add a space to
	 * error string.
	 * </p>
	 * 
	 * @param lookahead
	 *            : A character which is being lookahead.
	 */
	public void addChar(char lookahead) {
		correctString += lookahead;
		errorString += ' ';
	}

	/**
	 * <p>
	 * Only add a character to correct string.
	 * </p>
	 * 
	 * @param lookahead
	 *            : A character which is being lookahead.
	 */
	public void addCorrectString(char lookahead) {
		correctString += lookahead;
	}

	/**
	 * <p>
	 * Only add a character to error string.
	 * </p>
	 * 
	 * @param lookahead
	 *            : A character which is being lookahead.
	 */
	public void addErrorString(char lookahead) {
		errorString += lookahead;
	}

	/**
	 * <p>
	 * Point out an error of input string
	 * </p>
	 * 
	 * @param errorType
	 *            : error type for input expression.
	 * @see ExceptionManager#SYNTAX_ERROR_EMPTY
	 * @see ExceptionManager#SYNTAX_ERROR_LACK_OPERATOR
	 * @see ExceptionManager#SYNTAX_ERROR_LACK_OPERAND
	 * @see ExceptionManager#LEXICAL_ERROR
	 * @see ExceptionManager#UNKNOW_ERROR
	 * @param lookahead
	 *            : the character in the position of error
	 */
	public void addError(int errorType, int lookahead) {
		isError = true;
		errorString += "^";
		if (errorType == ExceptionManager.SYNTAX_ERROR_EMPTY) {
			errorMessage += "Syntax Error: Empty expression!\n";
		} else if (errorType == ExceptionManager.SYNTAX_ERROR_LACK_OPERATOR) {
			errorMessage += "Syntax Error \'" + (char) lookahead + "\' : Lack of operators!\n";
		} else if (errorType == ExceptionManager.SYNTAX_ERROR_LACK_OPERAND) {
			errorMessage += "Syntax Error \'" + (char) lookahead + "\' : Lack of operand!\n";
		} else if (errorType == ExceptionManager.LEXICAL_ERROR) {
			errorMessage += "Lexical Error \'" + (char) lookahead
					+ "\' : input character isn't in character set!\n";
		} else {
			errorMessage += "Unknow error type!\n";
		}
	}
}
