// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   IllegalIdentifierLengthException.java

package exceptions;

// Referenced classes of package exceptions:
//			LexicalException

public class IllegalTypeException extends SemanticException {

	public IllegalTypeException(int i, int j) {
		this((new StringBuilder()).append("Type undefined.\nThe error position is Line ").append(i).append(" Column ")
				.append(j).toString());
	}

	public IllegalTypeException() {
		this((new StringBuilder()).append("Type undefined.\n").toString());
	}

	public IllegalTypeException(String s) {
		super(s);
	}
}
