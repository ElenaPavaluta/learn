package days.d5_7.t4;

class Q5 {

	static void m() {
		int num1 = 8;
		int num2 = 8;

		for (int i = 0; i < 3; i++) {
			if (num1 == num2) {
				try {
					System.out.println("t");
				} catch (Exception e) {
					System.out.println("c");
				} finally {
					System.out.println("finally");
				}
			}
		}
	}

	static void m2() {
		int num1 = 8;
		int num2 = 8;

		for (int i = 0; i < 3; i++)
			if (num1 == num2)
				try {
					System.out.println("t");
				} catch (Exception e) {
					System.out.println("c");
				} finally {
					System.out.println("finally");
				}

	}

	public static void main(String[] args) {
		m();
		m2();
	}

}
