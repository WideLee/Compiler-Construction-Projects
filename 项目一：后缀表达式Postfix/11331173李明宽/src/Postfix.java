import java.io.IOException;

/**
 * <p>
 * It is the main function for project Postfix.
 * </p>
 * 
 * @author Mingkuan Lee
 * 
 */
public class Postfix {

	public static void main(String[] args) throws IOException {
		System.out.println("Input an infix expression and output its postfix notation:");
		System.out.println(new Parser().expr());
		System.out.println("\nEnd of program.");
	}
}
