
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * <p>
 * It is a parser which is using loop method
 * </p>
 *
 * @see Parser
 * @author Mingkuan Lee
 *
 */
public class Parser_Frame {

    int lookahead;
    JLabel output;
    String inputString;
    int index;

    public Parser_Frame(JTextField input, JLabel output) throws IOException {
        this.output = output;
        inputString = input.getText();
        inputString += "\0";
        index = 0;
        lookahead = inputString.charAt(index);
    }

    public void expr() throws IOException {
        term();
        while (true) {
            if (lookahead == '+') {
                match('+');
                term();
                output.setText(output.getText() + '+');
            } else if (lookahead == '-') {
                match('-');
                term();
                output.setText(output.getText() + '-');
            } else {
                break;
            }
        }
    }

    public void term() throws IOException {
        if (Character.isDigit((char) lookahead)) {
            output.setText(output.getText() + (char) lookahead);
            match(lookahead);
        } else {
            throw new Error("syntax error" + (char) lookahead);
        }
    }

    public void match(int t) throws IOException {
        if (lookahead == t) {
            lookahead = inputString.charAt(++index);
        } else {
            throw new Error("syntax error");
        }
    }
}
