// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel
// Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space
// Source File Name: SemanticException.java

package exceptions;

// Referenced classes of package exceptions:
// ExpressionException

public class SemanticException extends ExpressionException {

	public SemanticException() {
		this("Semantic error.");
	}

	public SemanticException(String s) {
		super(s);
	}
}
