package oc.a.chapters.c6_exceptions.recognizingCommonExceptionTypes.runtimeExceptions;

public class ClassCastException {

	static void m() {
		String type = "moose";

		/*
		 * compiler error: cannot make this cast due to the fact that there's no
		 * hierarchy between String and Integer
		 */
		// Integer number = (Integer)type;
	}

	static void m2() {
		String type = "moose";
		Object obj = type;

		/*
		 * The compiler doesn't complains but the problem is that in fact
		 * there's a String which is casted into an Integer. Obviously there's
		 * going to be CastClassException
		 */
		Integer number = (Integer) obj;

	}
	
	public static void main(String[] args) {
		m2();
	}
}
