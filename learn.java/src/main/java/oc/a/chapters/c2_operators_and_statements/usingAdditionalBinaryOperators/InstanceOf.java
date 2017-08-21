package oc.a.chapters.c2_operators_and_statements.usingAdditionalBinaryOperators;

/**
 * a instanceof b
 * 
 * True if the reference that a points to is an instance of a class, subclass,
 * or class that implements a particular interface, as named in b
 * 
 *
 */
public class InstanceOf {

	static void m() {
		A o = new A();
		System.out.println(o instanceof I); // true
		System.out.println(o instanceof A); // true
		System.out.println(o instanceof B); // false
		System.out.println(o instanceof I2); // false
		System.out.println(o instanceof A2); // false
		System.out.println(o instanceof B2); // false
	}

	static void m2() {
		B o = new B();

		System.out.println(o instanceof I); // true
		System.out.println(o instanceof A); // true
		System.out.println(o instanceof B); // true
		System.out.println(o instanceof I2); // false
		System.out.println(o instanceof A2); // false
		System.out.println(o instanceof B2); // false

	}

	static void m3() {
		A o = new B();

		System.out.println(o instanceof I); // true
		System.out.println(o instanceof A); // true
		System.out.println(o instanceof B); // true
		System.out.println(o instanceof I2); // false
		System.out.println(o instanceof A2); // false
		System.out.println(o instanceof B2); // false
	}

	static void m4() {
		A o = new A2();

		System.out.println(o instanceof I); // true
		System.out.println(o instanceof A); // true
		System.out.println(o instanceof B); // true
		System.out.println(o instanceof I2); // true
		System.out.println(o instanceof A2); // true
		System.out.println(o instanceof B2); // false
	}

	static void m5() {
		A o = new B2();

		I i = new B2();
		A a = new B2();
		B b = new B2();
		I2 i2 = new B2();
		A2 a2 = new B2();
		B2 b2 = new B2();

		System.out.println(o instanceof I); // true
		System.out.println(o instanceof A); // true
		System.out.println(o instanceof B); // true
		System.out.println(o instanceof I2); // true
		System.out.println(o instanceof A2); // true
		System.out.println(o instanceof B2); // true
	}

	static void m6() {
		A a = new A();

		// System.out.println(a instanceof null); //not allowed: It needs to be
		// a class literal

		System.out.println(null instanceof A); // false in every case
	}

	public static void main(String[] args) {
		// m();
		// m2();
		// m3();
		// m4();
		// m5();
		m6();
	}

}

interface I {
}

class A implements I {
}

class B extends A {
}

interface I2 {
}

class A2 extends B implements I2 {
}

class B2 extends A2 {
}
