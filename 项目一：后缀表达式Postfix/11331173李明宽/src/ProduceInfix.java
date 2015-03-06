/**
 * <p>
 * This class can produce an random infix expression, it may be used for testing
 * the Parser is correct, and compare the efficiency between Parser_Loop and
 * Parser_Recursive
 * </p>
 * 
 * @author Mingkuan Lee
 * 
 */
public class ProduceInfix {

	/**
	 * <p>
	 * It produce a infix expression.
	 * </p>
	 * <p>
	 * The expression satisfied the rule below :<br>
	 * 1. The operators only contain '+' and '-'. <br>
	 * 2. The operand is digit which means it only can be '0'-'9'.
	 * </p>
	 * 
	 * @param length
	 *            : The length of output infix expression
	 * @return : A infix expression which length is the parameter
	 *         <code>length</code>.
	 * @throws IllegalArgumentException
	 *             : while the length is even number.
	 */
	public static String getRandomInfix(int length) {
		if (length % 2 == 0) {
			throw new IllegalArgumentException("Length of infix must be an odd number!");
		}
		String infix = new String();
		for (int i = 0; i < length; i++) {
			if (i % 2 == 0) {
				infix += getRandomNum();
			} else {
				infix += getRandomOpt();
			}
		}
		return infix;
	}

	/**
	 * <p>
	 * Produce a random digit.
	 * </p>
	 * 
	 * @return a digit is in the range '0'-'9'.
	 */
	public static int getRandomNum() {
		int ran = (int) (Math.random() * 10);
		return ran;
	}

	/**
	 * <p>
	 * Produce a random operator, '+' or '-'.
	 * </p>
	 * 
	 * @return : a character '+' or '-'.
	 */
	public static char getRandomOpt() {
		char opt = Math.random() > 0.5 ? '+' : '-';
		return opt;
	}
}
