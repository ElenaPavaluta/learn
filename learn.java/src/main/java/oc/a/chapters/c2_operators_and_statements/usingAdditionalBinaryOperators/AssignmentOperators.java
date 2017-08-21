package oc.a.chapters.c2_operators_and_statements.usingAdditionalBinaryOperators;

public class AssignmentOperators {

	static void m() {
		// int x = 1.0; // compiler error: literal of type double
		int x = (int) 1.0;

		// short y = 1921222; //compiler error: the compiler detects that the
		// value it's outsiede the range for a short value
		short y = (short) 1921222;
		System.out.println(y); // 20678

		// int z = 9f;
		int z = (int) 9f;

		/*
		 * compiler error: the value it's too great to fit in an int (Remember:
		 * the numeric literal in java are by default of type int)
		 */
		// long t = 192301398193810323;
		long t = 192301398193810323L;
	}

	static void m2() {
		short x = 10; // although 10 is of type int is narrowed to fit in a
						// short type; The compiler allows this beucase the
						// value it's within the range of the short data type
		short y = 3;

		short z = (short) (x * y); // both x and y are automatically promoted to
									// int data types as the rule of numeric
									// promotion says (for data types smaller
									// than int)

	}

	public static void main(String[] args) {
		m();
	}
}
