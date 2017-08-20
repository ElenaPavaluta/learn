package chapters.c3_usingOperatorsAndDecisionConstructs.q38;

class Q {

	static void m() {
		int colorOfRainbow = 10;

		final int red = 10;

		switch (colorOfRainbow) {
		default:
			System.out.println("Home");
			break;
		/*
		 * byte, short, char, int (also their wrapper classes) enum and Stirng
		 * 
		 * the variable needs to be constant in order to use them in switch
		 * statements
		 */
		case red:
			System.out.println("Away");
			break;
		}
	}

	static void m2() {
		char c = 'c';
		final char a = 'a' + 2;

		switch (c) {
		default:
			System.out.println("default");
		case a:
			System.out.println("match");
		}
	}

	static void m3() {
//		int i = 3;
		int i = 6;

		switch (i) {
		default:
			System.out.println("default");
			break;
		case 1:
		case 2:
		case 3:
			System.out.println("1 2 3");
		case 4:
			System.out.println(4);
		case 5:
			System.out.println(5);
			System.out.println(55);
			break;
		// case 3: //compiler error: the case should not repeat itself
	}
	}

	public static void main(String[] args) {
		// m();
		// m2();
		m3();
	}
}
