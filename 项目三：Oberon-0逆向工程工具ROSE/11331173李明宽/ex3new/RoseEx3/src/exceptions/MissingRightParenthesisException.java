// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MissingRightParenthesisException.java

package exceptions;

// Referenced classes of package exceptions:
//			SyntacticException

public class MissingRightParenthesisException extends SyntacticException {

	public MissingRightParenthesisException(int i, int j) {
		this((new StringBuilder()).append("Miss right parenthesis.\nThe error position is Line ").append(i)
				.append(" Column ").append(j).toString());
	}

	public MissingRightParenthesisException() {
		this((new StringBuilder()).append("Miss right parenthesis.\n ").toString());
	}

	public MissingRightParenthesisException(String s) {
		super(s);
	}
}
