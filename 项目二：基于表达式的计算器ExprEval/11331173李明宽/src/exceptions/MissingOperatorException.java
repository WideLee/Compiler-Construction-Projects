// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel
// Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space
// Source File Name: MissingOperatorException.java

package exceptions;

// Referenced classes of package exceptions:
// SyntacticException

public class MissingOperatorException extends SyntacticException {

	public MissingOperatorException() {
		this("An operator is expected.");
	}

	public MissingOperatorException(String s) {
		super(s);
	}
}
