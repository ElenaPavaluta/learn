package oc.a.chapters._2_operators_and_statements.binaryArithmeticOperators;

/**
 * Numeric Promotion Rules
 * 
 * 
 * 1. If two values have different data types, Java will automatically promote
 * one of the values to the larger of the two data types.
 * 
 * 2. If one of the values is integral and the other is floating-point, Java
 * will automatically promote the integral value to the floating-point value�s
 * data type.
 * 
 * 3. Smaller data types, namely byte, short, and char, are first promoted to
 * int any time they�re used with a Java binary arithmetic operator, even if
 * neither of the operands is int.
 * 
 * 
 * 4. After all promotion has occurred and the operands have the same data type,
 * the resulting value will have the same data type as its promoted operands.
 */

public class NumericPromotion {

	static void m() {
		int x = 1;
		long y = 33;

		long r = x * y; // x, it's firt promoted to long
		System.out.println(r);
	}

	static void m2() {
		double x = 39.21;
		float y = 2.1f;

		double r = x + y; // y, it's promoted to double first
	}

	static void m3() {
		short x = 10;
		short y = 3;

		int r = x / y; //
	}

	static void m4() {
		short x = 14;
		float y = 13;
		double z = 30;

		double r = x * y / z;
	}
}
