package oc.a.chapters.c3_core_java_apis.equality;

public class Equality {

	static void m() {
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		StringBuilder sb3 = sb.append("a");

		System.out.println(sb == sb2); // false
		System.out.println(sb == sb3); // true
	}

	static void m2() {
		String x = "Hello world";
		String y = "Hello world";

		System.out.println(x == y); // true (they refer to the same String
									// object which, stored in the String pool)
	}

	static void m3() {
		String x = "Hello world";
		String y = "Hello world".trim();
		String z = " Hello world".trim();

		System.out.println(x == y); // true
		System.out.println(x == z); // false
		System.out.println(y == z); // false

		/*
		 * although the string.trim() is evaluated at runtime, the first case
		 * it's still ...
		 * 
		 * The probable argumentation for first case outcome: due to the fact
		 * that the method has no effect on the applied object, it returns the
		 * same object
		 */
	}

	static void m4() {
		String x = new String("Hello world");
		String y = "Hello world";

		System.out.println(x == y); // because a specifically String object has
									// been requested the pooled value hasn't
									// been shared
	}

	public static void main(String[] args) {
		// m();
		// m2();
//		 m3();
		m4();

	}
}
