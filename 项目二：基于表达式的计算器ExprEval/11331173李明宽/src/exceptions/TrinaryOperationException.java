// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel
// Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space
// Source File Name: TrinaryOperationException.java

package exceptions;

// Referenced classes of package exceptions:
// SyntacticException

public class TrinaryOperationException extends SyntacticException {

	public TrinaryOperationException() {
		this("Syntactic error in trinary operation.");
	}

	public TrinaryOperationException(String s) {
		super(s);
	}
}
