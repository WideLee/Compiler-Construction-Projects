//OberonMain.java
import java.io.*;
import exceptions.*;

/**
 * Oberon编译器测试主程序
 * 
 */
public class OberonMain {
    /**
     * Oberon编译器测试
     * 
     * @param argv
     *            命令行参数
     * @throws FileNotFoundException
     *             若找不到文件，抛出异常
     */
    public static void main(String argv[]) throws FileNotFoundException {
	Parser p = new Parser(new OberonScanner(new FileReader(argv[0])));
	try {
	    p.parse();
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	    e.printStackTrace();
	}
    }
}