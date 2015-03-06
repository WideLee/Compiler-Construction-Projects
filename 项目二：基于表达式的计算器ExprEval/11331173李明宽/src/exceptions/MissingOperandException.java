// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel
// Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space
// Source File Name: MissingOperandException.java

package exceptions;

// Referenced classes of package exceptions:
// SyntacticException

public class MissingOperandException extends SyntacticException {

	public MissingOperandException() {
		this("An operand is expected.");
	}

	public MissingOperandException(String s) {
		super(s);
	}
}
