// Decompiled by Jad v1.5.8e2. Copyright 2001
// Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst
// ansi space
// Source File Name: Calculator.java

package parser;

import exceptions.ExpressionException;

/**
 * <p>
 * 计算器类，用于给上层调用，通过实例化一个可以从上层中获得一个表达式字符串，
 * 这里返回一个双精度Double类型的运算结果
 * </p>
 * 
 * @author limkuan
 * 
 */
public class Calculator {

	public Calculator() {
	}

	/**
	 * <p>
	 * 使用这个函数可以计算得出一个表达式所给出的结果，如：
	 * </p>
	 * <code>result = Cal.calculate(exprString);</code>
	 * <p>
	 * 其中，result就是字符串表达式exprString的计算结果。 <br>
	 * 个人觉得可以直接把这个函数变成静态的，这样调用更加方便
	 * </p>
	 * 
	 * @param s
	 *            : 要求值的字符串
	 * @return ： double双精度的结果
	 * @throws ExpressionException
	 *             ： Parser中抛出的异常，这里不新加异常
	 */
	public double calculate(String s) throws ExpressionException {
		Parser parser = new Parser(s);

		parser.parser();
		return parser.result;
	}
}
