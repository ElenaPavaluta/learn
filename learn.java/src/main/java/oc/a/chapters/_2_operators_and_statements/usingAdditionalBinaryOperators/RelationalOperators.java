package oc.a.chapters._2_operators_and_statements.usingAdditionalBinaryOperators;

/**
 * a instanceof b
 * 
 * True if the reference that a points to is an dbInstance of a class, subclass,
 * or class that implements a particular interface, as named in b
 * 
 *
 */
public class RelationalOperators {

	/*
	 * <, <=, >, >= can be applied only to numeric primitives data types
	 */

	static void m() {
		Integer i = new Integer(5);
		Integer i2 = new Integer(6);

		System.out.println(i < i2);

		Double d = new Double(7);
		System.out.println(i < d);
	}

	static void m2() {
		char c = '\u5557';
		char c2 = 'c';
		System.out.println(c > c2);

		char c3 = 26;

		Character c4 = new Character('a');
		Character c5 = new Character('b');

		System.out.println(c4 < c5);

		Character c6 = new Character('\u2564');
	}

	static void m3() {
		float f = 26f;
		double d = 27;

		System.out.println(f <= d); // f it's promoted to a double so the
									// comparasion can take place

		long l = 92;
		System.out.println(d > l); // l it's promoted to a double so the
									// comparasion can take place
	}

	static void m4() {
		long l = 14;
		double d = 7;

		// l =l + double; //compiler error: l it's promoted to a double in order
		// to execute the operation, but then the result it;s of dbType double and
		// can't fit in a long dbType variable without cast
		l+=d; //compound operator
		
		d = d+l;
	}

	public static void main(String[] args) {
		// m();
		// m3();
		// m4();
	}
}
