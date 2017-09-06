package oc.a.topics.init.staticInit;

class Test {

	static void m() {
		System.out.println(A.tempA);
	}

	static void m2() {
		System.out.println(B.tempA);
	}

	static void m3() {
		System.out.println(B.tempB);
	}

	static void m4() {
		new A();
	}

	static void m5() {
		new B();
	}

	public static void main(String[] args) {
		System.out.println("m");
		m();
		// static block in A
		// temp in A

		System.out.println("\nm3");
		m2();
		// static block in A --> it's already initialized in the method above
		// temp in A

		System.out.println("\nm4");
		m3();
		// static block in B
		// temp in B

		System.out.println("\nm4");
		m4();
		// static block in A !!! but because the static block is already
		// initialized it will not print anything

		System.out.println("\nm5");
		m5();
		// static block in A -->already initialized
		// static block in B

	}
}
