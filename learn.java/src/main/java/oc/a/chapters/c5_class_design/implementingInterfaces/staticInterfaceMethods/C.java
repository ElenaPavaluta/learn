package oc.a.chapters.c5_class_design.implementingInterfaces.staticInterfaceMethods;

import utils.delimitators.Delimitators;

public class C implements StaticInterfaceMethods {

	static void m() {
		C c = new C();

		c.defaultMethod();
		/*
		 * compiler error: A static interface method can be accessed only with
		 * the interface dishName
		 */
		// c.staticMethod();
	}

	static void m2() {
		/*
		 * A defaulT interface method can be accessed only through an
		 * implementing class
		 */
		// StaticInterfaceMethods.defaultMethod();

		StaticInterfaceMethods.staticMethod();
	}

	static void m3() {
		StaticInterfaceMethods m = new C();

		m.defaultMethod();

		/*
		 * compiler error: m reference type: StaticInterfaceMethods and it
		 * points to implementing class: the compiler still throws an error
		 */
		// m.staticMethod();
	}

	public static void main(String[] args) {
		m();
		Delimitators.newLine();
		m2();
		Delimitators.newLine();
		m3();
	}
}
