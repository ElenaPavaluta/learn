package chapters.c1_building_blocks.object_reference_and_primitives.primitives.numericType.integralType;

/**
 * The integer literal can be used for any type of numeric data type
 */
public class IntegerLiterals {

	public static void m() {
		int i;

		i = 27;
		i = 2_7;
		i = 0b01;
		i = 077;
		i = 0xa;

		// i = 00b01;
		// i = 0b_01;
		// i = 0_b01;
		i = 0b0_1;

		i = 07;
		i = 007;
		i = 000007;
		// i= 08;
		// i=008;
		// i = 000008;

		i = 0_0_0_0;
		char c = 0_0_0_0; //narrowing
		i = 0_7;
		i = 0_7_0;

		System.out.println("i: " + i);

		c = 0_0_0_7;
		System.out.println("c: " + c);
		System.out.println("c: " + Integer.valueOf(c));

		double d = 0_0_7; // widening through numerical promotion
		System.out.println("d:" + d);
	}

	public static void main(String[] args) {
		m();
	}
}
