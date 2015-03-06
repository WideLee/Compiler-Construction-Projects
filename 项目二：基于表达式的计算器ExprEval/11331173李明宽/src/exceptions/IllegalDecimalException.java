// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel
// Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space
// Source File Name: IllegalDecimalException.java

package exceptions;

// Referenced classes of package exceptions:
// LexicalException

public class IllegalDecimalException extends LexicalException {

	public IllegalDecimalException() {
		this("Malformed decimal constant.");
	}

	public IllegalDecimalException(String s) {
		super(s);
	}
}
