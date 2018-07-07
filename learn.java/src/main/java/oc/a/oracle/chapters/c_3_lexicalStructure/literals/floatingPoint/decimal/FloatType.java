package oc.a.oracle.chapters.c_3_lexicalStructure.literals.floatingPoint.decimal;

import static utils.print.Print.*;

public class FloatType {
	static float f;

	static void binary() {
		f = 0b100; // an int literal
		print("binary", f);

		f = 0b1_0_0;
		// f = 0b_1_0_0;
		// _ can't be at the beginning (works only for octal)

		 f=0b1_0_0;
		// it's a int literal which it's widened to fit in a float (through
		// numerical promotion)

		// f = 0b01e0b1;
		// not allowed
	}

	static void octal() {
		f = 0_0_7; // an int literal
		// f = 008; //not an octal

		// f = 007e007;
		f = 007e007f; // not an octal

		f = 0_0_7.0_0_7f; // not an ocatal
		f = 008.008f;

		f = 0_0_8.0_2e-0_0_8f; // not an octal
		print("octal", f);
	}

	static void decimalFloatingPointLiteral() {
		f = 09.09e-009f;
		print("f1", f);

		f = .009e-9f;
		print("f2", f);

		f = 9e2f; // it's absolutely necessary to add the floating dbType suffix
					// due to the fact that the integers can't use the exponent
					// part
		f = 27f;
		double d = 9e2; // it doesn't need the floating dbType suffix because for
						// double dbType it's implicit
	}

	public static void main(String[] args) {
		// binary();
		// octal();
		decimalFloatingPointLiteral();
	}
}
