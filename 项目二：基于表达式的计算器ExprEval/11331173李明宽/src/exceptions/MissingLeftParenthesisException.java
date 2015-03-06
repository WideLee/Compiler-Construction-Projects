// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel
// Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space
// Source File Name: MissingLeftParenthesisException.java

package exceptions;

// Referenced classes of package exceptions:
// SyntacticException

public class MissingLeftParenthesisException extends SyntacticException {

	public MissingLeftParenthesisException() {
		this("Left parenthesis '(' is expected.");
	}

	public MissingLeftParenthesisException(String s) {
		super(s);
	}
}
