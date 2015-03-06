// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel
// Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space
// Source File Name: MissingRightParenthesisException.java

package exceptions;

// Referenced classes of package exceptions:
// SyntacticException

public class MissingRightParenthesisException extends SyntacticException {

	public MissingRightParenthesisException() {
		this("Right parenthesis ')' is expected.");
	}

	public MissingRightParenthesisException(String s) {
		super(s);
	}
}
