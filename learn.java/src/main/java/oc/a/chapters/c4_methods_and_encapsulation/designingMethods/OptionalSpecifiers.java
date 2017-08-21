package oc.a.chapters.c4_methods_and_encapsulation.designingMethods;

public abstract class OptionalSpecifiers {

	static void m() {
	};

	abstract void m2();

	final void m3() {
	};

	synchronized void m4() {

	};

	native void m5(); // used when interacting with code written in another
						// language such as C++

	strictfp void m6() {
		// used for making floating pint calculations portable
	};
}
