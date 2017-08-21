package oc.a.oracle.chapters.c_3_lexicalStructure.literals.string;

/*
 * A string literal it's a reference to an instance of a class String
 * 
 * Literal strings within different classes in different packages represent references to the same String object
 * 
 * Strings computed by constant expression are computed at compile time and then treated as if they were literals
 * Strings computed by concatenation at run time are newly created and therefore distinct
 *  
 * The result of explicitly interning a computed String is the same string as any pre-existing literal string with the same content 
 *  
 */
public class StringLiteral {

	static void m() {
		String hello = "Hello", lo = "lo";

		System.out.println(hello == "Hello");  //true
		System.out.println(Other.hello == hello);  //true
		System.out.println( Other.hello == hello);  //true

		System.out.println(hello == ("Hel" + "lo")); // true, an expression
														// evaluated at compile
														// time, due to the fact
														// that its members are
														// constants

		System.out.println(hello == ("Hel" + lo)); // false, an expression
													// evaluated at run time

		System.out.println(hello == ("Hel" + lo).intern()); // true. intern ->a
															// string
															// that has the same
															// contents as this
															// string, but is
															// guaranteed to be
															// from a pool of
															// unique strings.
	}

	static void m2() {
		String abcd27 = "abcd27";

		System.out.println(abcd27 == "abcd27"); // true, evaluated at compile
												// time

		System.out.println(("a" + 'b' + "cd" + 27) == "abcd27"); // true,
																	// constant
																	// expression
																	// evaluated
																	// at
																	// compile
																	// time

		String q = "a" + 'b' + "cd" + 27;
		System.out.println(q == abcd27); // true
		String a = "a";
		String b = "b";
		String c = "c";
		String d = "d";
		int nr = 27;
		a = a + b + c + d + nr;

		System.out.println(a == abcd27); // false, evaluated expression at run
											// time

		System.out.println(a.intern() == abcd27); // true, intern() used

		System.out.println(new String(abcd27) == abcd27); // false, different
															// object
		System.out.println(new String(abcd27).intern() == abcd27); // true,
																	// intern
																	// used()
	}

	public static void main(String[] args) {
		 m();
//		m2();
	}
}

class Other {
	public static String hello = "Hello";
}
