import java.io.IOException;

/**
 * <p>
 * It is a parser which is using recursive method
 * </p>
 * 
 * @see Parser
 * @author Mingkuan Lee
 * 
 */
public class Parser_Recursive {
    static int lookahead;

    public Parser_Recursive() throws IOException {
	lookahead = System.in.read();
    }

    public void expr() throws IOException {
	term();
	rest();
    }

    public void rest() throws IOException {
	if (lookahead == '+') {
	    match('+');
	    term();
	    System.out.write('+');
	    rest();
	} else if (lookahead == '-') {
	    match('-');
	    term();
	    System.out.write('-');
	    rest();
	} else {
	    // do nothing with the input
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
