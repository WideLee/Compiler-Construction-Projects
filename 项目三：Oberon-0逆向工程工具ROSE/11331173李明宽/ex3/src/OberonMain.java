import exceptions.*;
import java.io.*;

/**
 * Main function of Oberon Complier
 * 
 */
public class OberonMain {
    /**
     * Test of Oberon Complier
     * 
     * @param argv
     *            parameters of command
     * @throws FileNotFoundException
     *             If can't find this file, throw this exception
     */
    public static void main(String argv[]) throws FileNotFoundException {
	Parser p = new Parser(new OberonScanner(new FileReader(argv[0])));
	try {
	    p.parse();
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
    }
}
