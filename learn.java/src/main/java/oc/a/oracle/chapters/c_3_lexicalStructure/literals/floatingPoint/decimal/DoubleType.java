package oc.a.oracle.chapters.c_3_lexicalStructure.literals.floatingPoint.decimal;

import static utils.print.Print.*;

public class DoubleType {

	private static double d;

	static void binary() {
		d = 0b01;
		// d = 0b01d;
	}

	static void octal() {
		d = 0__7;
	}

	static void dt() {
		d = 0__9.0__9e0__9;
		print("d1", d);

		d = .0___9;

		d = 0__9e0__9;

		d = 09e09d;
	}

	public static void main(String[] args) {
		dt();
	}
}
