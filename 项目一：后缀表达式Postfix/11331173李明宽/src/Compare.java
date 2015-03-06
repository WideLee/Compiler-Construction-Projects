import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Compare {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int testcase;
		int infixLength = 1001;
		PrintStream stdout = System.out;

		for (int k = 100; k <= 1000; k += 100) {
			testcase = k;
			List<String> infixStrings = new ArrayList<>();
			for (int i = 0; i < testcase; i++) {
				infixStrings.add(ProduceInfix.getRandomInfix(infixLength));
			}

			System.out.println("It has " + testcase + " testcases, \n"
					+ "each testcase has an infix expression of length " + infixLength
					+ "\n Now, begin test...");

			try {
				System.setOut(new PrintStream("recursive_test.txt"));
				long recursiveBeginTime = System.currentTimeMillis();
				for (int i = 0; i < testcase; i++) {
					System.out.print("testcast " + (i + 1) + " : ");
					System.setIn(new ByteArrayInputStream(infixStrings.get(i).getBytes()));
					new Parser_Recursive().expr();
					System.out.println();
				}
				long recursiveEndTime = System.currentTimeMillis();

				System.setOut(stdout);
				System.out.println("Recursive method use "
						+ (recursiveEndTime - recursiveBeginTime) + " msec.\n"
						+ "Its output message is in file <recursive_test.txt>");				
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				System.setOut(new PrintStream("loop_test.txt"));
				long loopBeginTime = System.currentTimeMillis();
				for (int i = 0; i < testcase; i++) {
					System.out.print("testcast " + (i + 1) + " : ");
					System.setIn(new ByteArrayInputStream(infixStrings.get(i).getBytes()));
					new Parser_Loop().expr();
					System.out.println();
				}
				long loopEndTime = System.currentTimeMillis();

				System.setOut(stdout);
				System.out.println("Loop method use " + (loopEndTime - loopBeginTime) + " msec.\n"
						+ "Its output message is in file <loop_test.txt>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
