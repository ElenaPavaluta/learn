package oc.a.chapters.c6_exceptions.recognizingCommonExceptionTypes.runtimeExceptions;

public class NullPointerException {

	static void m() {
		String s = null;

		System.out.println(s.charAt(5));
	}

	public static void main(String[] args) {
		m();
	}
}
