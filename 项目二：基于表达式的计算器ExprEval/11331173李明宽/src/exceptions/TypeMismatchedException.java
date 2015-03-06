// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel
// Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space
// Source File Name: TypeMismatchedException.java

package exceptions;

// Referenced classes of package exceptions:
// SemanticException

public class TypeMismatchedException extends SemanticException {

	public TypeMismatchedException() {
		this("Type mismatched.");
	}

	public TypeMismatchedException(String s) {
		super(s);
	}
}
