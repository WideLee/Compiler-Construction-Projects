// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel
// Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space
// Source File Name: DividedByZeroException.java

package exceptions;

// Referenced classes of package exceptions:
// SemanticException

public class DividedByZeroException extends SemanticException {

	public DividedByZeroException() {
		this("Divided by 0.");
	}

	public DividedByZeroException(String s) {
		super(s);
	}
}
