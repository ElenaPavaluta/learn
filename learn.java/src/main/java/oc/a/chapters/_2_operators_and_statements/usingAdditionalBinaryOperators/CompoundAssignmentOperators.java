package oc.a.chapters._2_operators_and_statements.usingAdditionalBinaryOperators;

public class CompoundAssignmentOperators {

	static void m() {

		long x = 10;
		int y = 5;

		// y = y*x;
		/*
		 * does not compile: y it's promoted to a long data type, and then you
		 * have a long expression retrieving a long result, which without an
		 * explicit cats can't fit in an int data type
		 */
		y = (int) (y * x);

		/**
		 * The compound operator will first widen y to a long, apply the
		 * multiplication of two long values, and then cast the result to an int
		 */
		y *= x;
	}

	/**
	 * Assignment operator
	 * 
	 * The result of the assignment is an expression in and of itself, equal to
	 * the value of the assignment
	 */
	static void m2() {
		long x = 5;
		long y = (x = 3);
		System.out.println(x); // 3
		System.out.println(y); // 3
		/*
		 * The key here is that (x=3) does two things. First, it sets the value
		 * of the variable x to be 3. Second, it returns a value of the
		 * assignment, which is also 3;
		 */
	}

	public static void main(String[] args) {
		m2();
	}

}
