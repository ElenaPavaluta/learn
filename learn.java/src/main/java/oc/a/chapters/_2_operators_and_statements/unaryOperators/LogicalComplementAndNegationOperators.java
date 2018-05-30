package oc.a.chapters._2_operators_and_statements.unaryOperators;

/**
 * The logical complement operator, !, flips the value of ONLY boolean expression.
 * 
 *
 */
public class LogicalComplementAndNegationOperators {

	static void m() {
		boolean x = false;
		x = !x; // x = true
		System.out.println(x);
	}

	static void m2() {
		boolean x = false;

		// x = -x; //compiler error

		// int i = !5; //compiler error
		// boolean y = -true; //compiler error
		// boolean z = !0 //compiler error
	}

	public static void main(String[] args) {
		m();
	}
}
