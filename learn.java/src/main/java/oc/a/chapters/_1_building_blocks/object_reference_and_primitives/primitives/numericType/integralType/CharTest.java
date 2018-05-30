package oc.a.chapters._1_building_blocks.object_reference_and_primitives.primitives.numericType.integralType;

public class CharTest {

	public static void mChar() {
		char c;
		c = 123; // the literal type is int, but it's being narrowed to an char
					// type. Being a literal the compiler can check it's value
					// and can see that this value can fit into an char type
					// variable
		c = 1234;
		c = 12345;
		c = (char) 123456;

		char c2;
		c2 = '\u0000';
		c2 = '\uFFFF';
		c2 = '\uaAAa';
		c2 = '\uffff';
		// c2 = '\ufffff'; // it needs to have 4 hexadecimal characters (not
		// less, not more)
		System.out.println("c2: " + c2);
		System.out.println("c2: " + Integer.valueOf(c2));

		char c3;
		// c3 = -1;
		c3 = (char) (46 - 47); // It's not a runtime error. The value it's
								// treated as a positive value, due to the fact
								// that the internal representation of -1
								// (signed representation) it's
								// the same for 65535 (unsigned representation)

		System.out.println("c3: " + c3);
		System.out.println("c3: " + Integer.valueOf(c3));

		char c4;
		// c4 = -4; //there's an illegal assignment;
		c4 = (char) (1 - 5); // legal assignment if the result it's casted (from
								// an int. Also the casted result it's going to
								// be treated as an unsigned value
		System.out.println("c4: " + c4);
		System.out.println("c4: " + Integer.valueOf(c4));

		char c5 = '\u000f';
		char c6 = '\u0001';
		char c7 = 5;
		char c8 = 'a';
		char c10 = (char) (c5 + c6 + c7 + c8); // The plus operator
												// requires the operands to be
												// widened to integers (by
												// numeric promotion)
												// so then in order to save the
												// resulting
												// value in a char type
												// value we need to cast it
		System.out.println("c10:" + c10);
		System.out.println("c10:" + Integer.valueOf(c10));

		int i = -c10 + c10;
		System.out.println("i: " + i);

		c10++;
		c10++;
		char c9 = (char) ((char) c10 + (char) 1);

		System.out.println("c10 twice incremented: " + c10);
		System.out.println("c10 twice incremented: " + Integer.valueOf(c10));

		System.out.println("value of a: " + Integer.valueOf('a'));
	}

	public static void main(String[] args) {
		mChar();
	}
}
