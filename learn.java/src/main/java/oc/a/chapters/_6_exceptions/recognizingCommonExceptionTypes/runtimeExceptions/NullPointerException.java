package oc.a.chapters._6_exceptions.recognizingCommonExceptionTypes.runtimeExceptions;

public class NullPointerException {

	static void m() {
		String s = null;

		System.out.println(s.charAt(5));
	}

	public static void main(String[] args) {
		m();
	}
}
