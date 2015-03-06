import java.io.IOException;

/**
 * <p>
 * It is a parser which is using loop method
 * </p>
 * 
 * @see Parser
 * @author Mingkuan Lee
 * 
 */
public class Parser_Loop {
	int lookahead;

	public Parser_Loop() throws IOException {
		lookahead = System.in.read();
	}

	public void expr() throws IOException {
		term();
		while (true) {
			if (lookahead == '+') {
				match('+');
				term();
				System.out.write('+');
			} else if (lookahead == '-') {
				match('-');
				term();
				System.out.write('-');
			} else {
				break;
			}
		}
	}

	public void term() throws IOException {
		if (Character.isDigit((char) lookahead)) {
			System.out.write((char) lookahead);
			match(lookahead);
		} else
			throw new Error("syntax error");
	}

	public void match(int t) throws IOException {
		if (lookahead == t)
			lookahead = System.in.read();
		else
			throw new Error("syntax error");
	}
}
