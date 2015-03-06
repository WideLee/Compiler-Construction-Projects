// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel
// Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space
// Source File Name: EmptyExpressionException.java

package exceptions;

// Referenced classes of package exceptions:
// SyntacticException

public class EmptyExpressionException extends SyntacticException {

	public EmptyExpressionException() {
		this("The expression is empty.");
	}

	public EmptyExpressionException(String s) {
		super(s);
	}
}
