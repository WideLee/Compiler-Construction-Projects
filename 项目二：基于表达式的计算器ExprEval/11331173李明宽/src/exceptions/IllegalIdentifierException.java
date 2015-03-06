// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel
// Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space
// Source File Name: IllegalIdentifierException.java

package exceptions;

// Referenced classes of package exceptions:
// LexicalException

public class IllegalIdentifierException extends LexicalException {

	public IllegalIdentifierException() {
		this("Not a predefined identifier.");
	}

	public IllegalIdentifierException(String s) {
		super(s);
	}
}
