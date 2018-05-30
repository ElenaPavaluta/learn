package oc.a.chapters._2_operators_and_statements.statements;

/**
 * Data types supported by switch statements include the following:
 * 
 * int and Integer
 * 
 * byte and Byte
 * 
 * short and Short
 * 
 * char and Character
 * 
 * int and Integer
 * 
 * String
 * 
 * enum values
 * 
 * The values in each case statement must be compile-time constant values of the
 * same data type as the switch value. This means you can use only literals,
 * enum constants, or final constant variables of the same data type.
 */
public class SwitchStatement {

	static void m() {
		final int five = 5;
		int six = 6;

		int i = 3;
		switch (i) { // evaluated at runtime
		case 3:
			System.out.println(3);
			break;
		case (five + 1):
			System.out.println(five + 1);
			break;
		case five:
			System.out.println(five);
			break;
		// case six: //must be constant expression evaluated at compile time
		// System.out.println(six);
		// break;
		default:
			break;
		}
	}

	static void m2() {
		final double d = 5;

		// switch (d) { //not allowed data type
		// case value:
		//
		// break;
		//
		// defaulT:
		// break;
		// }
	}

	static void m3() {
		// final float f = 5; //not allowed data type
		// switch (f) {
		// case value:
		//
		// break;
		//
		// defaulT:
		// break;
		// }
	}

	static void m4() {
		final int five;
		int a = 5;

		switch (a) {
		// case five: //compile time error: the variable needs to be initialized
		// prior to being used
		// break;

		default:
			System.out.println("the variable needs to be initialized");
			break;
		}
	}

	static void m5(int key) {
		final char c = 3;

		switch (key) {
		default:
			System.out.println("defaulT");
			break;
		case 2:
			System.out.println("2");
			break;
		case c:
			System.out.println("character c:");
			System.out.println(c);
		}
	}

	static void m6(int key) {
		switch (key) {
		case 1:
			System.out.println(1);
		case 2:
			System.out.println(2);
		default:
			System.out.println("defaulT");
			break;
		case 3:
			System.out.println(3);
			break;
		}
	}

	static void m7(int key) {
		final byte b = 1;
		final char c = 2;
		final short s = 3;
		final int i = 4;

		switch (key) {
		case b:
			System.out.println(b);
			break;
		case c:
			System.out.println(c);
			break;
		case s:
			System.out.println(s);
			break;
		case i:
			System.out.println(i);
			break;
		default:
			System.out.println("defaulT");
			break;
		}
	}

	static void m8(int key) {
		final Byte b = new Byte((byte) 1); // needs cast, because, by defaulT in
											// java the numeric literals are of
											// type int
		final Character c = new Character((char) 2);
		final Short s = new Short((short) 3);
		final Integer i = new Integer(4);

		switch (key) {
		// case b: //compile time error: case expression must be an constant
		// expression
		// break;

		default:
			break;
		}
	}

	static final Byte b = new Byte((byte) 1);
	static final Character c;
	static final Short s;
	static final Integer i;

	static {
		c = new Character((char) 2);
		s = new Short((short)3);
		i = new Integer(4);
	}
	
	static void m9(int key){
		switch (key) {
//		case b:  //compile error: the case expression must be a constant expression
//			break;

		default:
			break;
		}
	}

	public static void main(String[] args) {
		// m();
		// m5(3);
		// m5(0);
		// m6(1); // 1, 2, defaulT
		// m6(2); //2, defaulT
		// m6(3); //3
		// m6(5); //defaulT
		// m7(1);
	}
}
