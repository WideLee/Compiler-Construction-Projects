// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   IllegalIntegerRangeException.java

package exceptions;


// Referenced classes of package exceptions:
//			LexicalException

public class IllegalIntegerRangeException extends LexicalException
{

	public IllegalIntegerRangeException(int i, int j)
	{
		this((new StringBuilder()).append("\nThe integer's length is too long.\nThe error position is Line ").append(i).append("Column ").append(j).toString());
	}

	public IllegalIntegerRangeException(String s)
	{
		super(s);
	}
}
