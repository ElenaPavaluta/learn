package days.d5_7.t3;

class Q10 {

	static void m() {
		int x = 10;

		double d = 4.;
		float f = 4.f;

		d = 4;
		f = 4;

		d = 0xf;
		f = 0xabf;
	}

	static void m2() {
		int x = 10;

		/*
		 * 4. is a double. Due to numeric promotion x is promoted to a double.
		 * 
		 * The switch statement only accepts: 
		 * 
		 * byte Byte 
		 * 
		 * char Char 
		 * 
		 * short Short
		 * 
		 * int Integer 
		 * 
		 * String 
		 * 
		 * enum values
		 */
		// switch (x%4.) {
		switch (x % 4) {
		default:
			System.out.println("default");
		case 0:
			System.out.println(0);
		}

	}

	public static void main(String[] args) {
		m2();
	}
}
