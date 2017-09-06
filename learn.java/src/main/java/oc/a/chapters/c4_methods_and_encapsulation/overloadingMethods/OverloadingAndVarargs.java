package oc.a.chapters.c4_methods_and_encapsulation.overloadingMethods;

public class OverloadingAndVarargs {

	public void fly(int[] arr) {
	};

	/*
	 * Compiler error: it's basically the same signature; the only difference
	 * comes from how those interfaceMethods are called
	 */
	// public void fly(int... arr){};

	class A {
		void fly(int[] arr) {
			System.out.println("int[] arr");
		}
	}

	class B {
		void fly(int... arr) {
			System.out.println("int... arr");
		}
	}

	public static void main(String[] args) {
		A a = new OverloadingAndVarargs().new A();
		B b = new OverloadingAndVarargs().new B();

		int[] arr = { 1, 2, 3 };

		a.fly(arr);
		b.fly(arr);

		// a.fly(); //compiler error
		b.fly(); // the method parameter is given the value: new int[0]

		a.fly(null);
		b.fly(null); // the method parameter is given the null value

		// a.fly(1,2,3); //compiler error
		b.fly(1, 2, 3);

	}
}
