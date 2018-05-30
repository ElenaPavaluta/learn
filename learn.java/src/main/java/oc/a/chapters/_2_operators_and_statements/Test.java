package oc.a.chapters._2_operators_and_statements;

public class Test {

	static int sum(int a, int b) {
		return a + b;
	}

	static void m() {
		int a = 1;
		int b = 2;
		System.out.println(sum(a++, b)); // 3, a++ it's evaluated to the
											// original expression, a = 2

		a = 1;
		b = 2;
		System.out.println(sum(++a, b)); // 4, ++a it's evaluated to the
											// incremented value, a = 2

		a = 1;
		b = 2;
		System.out.println(sum(a--, b)); // 3

		a = 1;
		b = 2;
		System.out.println(sum(--a, b)); // 2
	}

	static void m2() {
		int a = 1;
		int b = 2;

		System.out.println(a++ + b); // 3

		a = 1;
		b = 2;

		System.out.println(++a + b); // 4
	}

	static void m3() {
		int x = -3;
		// x--;
		// --x;
		System.out.println(x++);

	}

	static void m4() {
		int x = 5;
		int s = --x + x++;
		System.out.println(s); // 8
		System.out.println(x); // 5
	}

	static void m5() {
		int x = 5;
		int s = x++ + --x;
		System.out.println(s); // 10
		System.out.println(x);// 5
	}

	static void m6() {
		int x = 5;
		// --x++;
	}

	public static void main(String[] args) {
		// m();
		m2();
		// m4();
		// m4();
		// m5();

	}

}
