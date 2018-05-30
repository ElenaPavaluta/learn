package oc.a.chapters._2_operators_and_statements.statements;

/**
 * 
 * booleanExpression? expression_1: expression_2
 * 
 * expression: must return a value
 */
public class TernaryOperator {

	static void m() {
		int y = 10;
		final int x;
		if (y > 5)
			x = 2 * y;
		else
			x = 3 * y;
		System.out.println(x);
	}

	static void m2() {
		int y = 10;
		final int x;

		x = y > 5 ? 2 * y : 3 * y;
		System.out.println(x);
	}

	static void m3() {
		int y = 10;

		System.out.println(y > 5 ? 9 : "Horse"); // both expression return
													// 'something'

		// int animal = y > 5 ? 9 : "Horse"; // does not compile
	}

	static void m4() {
		int x = 5;
		// x == 5 ? System.out.println("5"):System.out.println("!5");
		// commpile
		// time error: the expression in the ternary operator must return a
		// value
	}

	public static void main(String[] args) {
		m();
		m2();
	}
}
