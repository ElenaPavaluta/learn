package oc.a.chapters.c3_core_java_apis.creatingAndManipulatingStrings.importantStringMethods;

public class ToLowerCaseAndToUpperCase {
	static String s = "Logitech";

	static String sm = s.toLowerCase();
	static String sM = s.toUpperCase();

	static {
		System.out.println(sm);
		System.out.println(sM);
	}

	static void m() {
		System.out.println(sm.equals(s.toLowerCase())); // true

		System.out.println(sm == "logitech"); // false, evaluated at runtime

		System.out.println(sm == s.toLowerCase()); // false: evaluated at
													// runtime

		System.out.println(s == "Logitech"); // true: constant expression
												// evaluated at compile time

		System.out.println(s == "Logitech".toLowerCase().replace('l', 'L')); // false
		System.out.println(s == "Logitech".toLowerCase().replace('l', 'L').intern()); // true
	}

	public static void main(String[] args) {
		m();
	}

}
