// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel
// Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space
// Source File Name: FunctionCallException.java

package exceptions;

// Referenced classes of package exceptions:
// SyntacticException

public class FunctionCallException extends SyntacticException {

	public FunctionCallException() {
		this("Syntactic error in function call.");
	}

	public FunctionCallException(String s) {
		super(s);
	}
}
