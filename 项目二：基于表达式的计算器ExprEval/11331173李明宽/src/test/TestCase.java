// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel
// Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space
// Source File Name: TestCase.java

package test;

public class TestCase {

	private String id;
	private String description;
	private String input;
	private String output;
	private boolean isExceptionExpected;

	public TestCase(String s, String s1, String s2, String s3, boolean flag) {
		id = s;
		description = s1;
		input = s2;
		output = s3;
		isExceptionExpected = flag;
	}

	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public String getInput() {
		return input;
	}

	public String getOutput() {
		return output;
	}

	public boolean isException() {
		return isExceptionExpected;
	}

	@Override
	public String toString() {
		return id + " " + description + "\nInput: " + input
				+ "\nExpected output: " + output;
	}
}
