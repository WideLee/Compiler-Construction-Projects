// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel
// Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space
// Source File Name: IllegalSymbolException.java

package exceptions;

// Referenced classes of package exceptions:
// LexicalException

public class IllegalSymbolException extends LexicalException {

	public IllegalSymbolException() {
		this("Unknown character.");
	}

	public IllegalSymbolException(String s) {
		super(s);
	}
}
