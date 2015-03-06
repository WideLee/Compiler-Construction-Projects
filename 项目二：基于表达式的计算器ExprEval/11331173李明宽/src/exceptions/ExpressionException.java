// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel
// Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space
// Source File Name: ExpressionException.java

package exceptions;

public class ExpressionException extends Exception {

	public ExpressionException() {
		this("Error found in the expression.");
	}

	public ExpressionException(String s) {
		super(s);
	}
}
