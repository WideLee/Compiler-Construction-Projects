// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MissingLeftParenthesisException.java

package exceptions;

// Referenced classes of package exceptions:
//			SyntacticException

public class IdentifierConflictException extends SemanticException {

	public IdentifierConflictException(int i, int j) {
		this((new StringBuilder())
				.append("Identifier is Conflict.You have define the id before.\nThe error position is Line ").append(i)
				.append(" Column ").append(j).toString());
	}

	public IdentifierConflictException() {
		this((new StringBuilder()).append("Identifier is Conflict.You have define the id before. \n").toString());
	}

	public IdentifierConflictException(String s) {
		super(s);
	}
}
