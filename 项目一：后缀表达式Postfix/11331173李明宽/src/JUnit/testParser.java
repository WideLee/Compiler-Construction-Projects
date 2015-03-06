import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class testParser {

	@Test
	public void test_1() throws IOException {
		
		List<String> strings = new ArrayList<>();
		strings.add("1+2+6-1-3");
		strings.add("1-2+5-2+4-1");
		strings.add("3+3+4+5-2-1-5-4");
		
		System.setIn(new ByteArrayInputStream(strings.get(0).getBytes()));
		Parser parser_1 = new Parser();
		assertEquals("12+6+1-3-",parser_1.expr());
		assertFalse(parser_1.exceptionManager.isError);
		
		System.setIn(new ByteArrayInputStream(strings.get(1).getBytes()));
		Parser parser_2 = new Parser();
		assertEquals("12-5+2-4+1-", parser_2.expr());
		assertFalse(parser_2.exceptionManager.isError);
		
		System.setIn(new ByteArrayInputStream(strings.get(2).getBytes()));
		Parser parser_3 = new Parser();
		assertEquals("33+4+5+2-1-5-4-", parser_3.expr());
		assertFalse(parser_3.exceptionManager.isError);
	}

	@Test
	public void test_2() throws IOException {
		List<String> strings = new ArrayList<>();
		strings.add("1+1+1+1+");
		strings.add("1++2+1");
		strings.add("1+-2");
		strings.add("1+2-=3+");
		
		System.setIn(new ByteArrayInputStream(strings.get(0).getBytes()));
		Parser parser = new Parser();
		parser.expr();
		assertTrue(parser.exceptionManager.isError);
		
		System.setIn(new ByteArrayInputStream(strings.get(1).getBytes()));
		Parser parser_1 = new Parser();
		parser_1.expr();
		assertTrue(parser_1.exceptionManager.isError);
		
		System.setIn(new ByteArrayInputStream(strings.get(2).getBytes()));
		Parser parser_2 = new Parser();
		parser_2.expr();
		assertTrue(parser_2.exceptionManager.isError);
		
		System.setIn(new ByteArrayInputStream(strings.get(3).getBytes()));
		Parser parser_3 = new Parser();
		parser_3.expr();
		assertTrue(parser_3.exceptionManager.isError);
	}
	
}
