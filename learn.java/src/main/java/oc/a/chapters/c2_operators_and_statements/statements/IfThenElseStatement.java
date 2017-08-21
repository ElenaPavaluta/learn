package oc.a.chapters.c2_operators_and_statements.statements;

/**
 * The if-then statement it's executed only if a boolean expression evaluates to
 * true at runtime
 *
 */
public class IfThenElseStatement {

	static void m(int hoursofDay) {
		if (hoursofDay > 5)
			System.out.println("if ( boolean condition) it's the simplest for of the if-then statement");
	}

	static void m2(int hoursofDay) {
		if (hoursofDay > 5) {
			System.out.println("{} required ");
			System.out.println("for multiple statements");
		}
	}

	static void m3(int hoursofDay) {
		if (hoursofDay < 11)
			System.out.println("Good morning");
		else
			System.out.println("Good afternoon");
	}

	static void m4(int hoursofDay) {
		if (hoursofDay < 11)
			System.out.println("Good morning");
		else if (hoursofDay < 18)
			System.out.println("Good afternoon");
		else if (hoursofDay < 23)
			System.out.println("Good evening");
		// System.out.println("How are u"); //compile error: needs {}
		else
			System.out.println("Hello owl");
		System.out.println(
				"Here this statement doesn't generates a compile error, It will be executed after the of-then-else statement");
	}

	static void m5(int hoursofDay) {
		if (hoursofDay < 11)
			System.out.println("Good morning");
		else if (hoursofDay < 18)
			System.out.println("Good afternoon");
		else if (hoursofDay < 23) {
			System.out.println("Good evening");
			System.out.println("How are u");
		} else
			System.out.println("Hello owl");
	}

	static void m6(int hoursofDay) {
		if (hoursofDay < 18) {
			System.out.println("Good afternoon");
		} else if (hoursofDay < 11) { // this branch never gets evaluated; due
										// to poor arrangement of conditions.
			System.out.println("Good morning");
		} else {
			System.out.println("Good evening");
		}
	}

	static void m7() {
		int x = 1;
		// if(x){} //compiler error; the condition must be a boolean expression

		// if(x=5){} //compiler error: not a boolean expression
	}

	public static void main(String[] args) {
		m5(24);
	}
}
