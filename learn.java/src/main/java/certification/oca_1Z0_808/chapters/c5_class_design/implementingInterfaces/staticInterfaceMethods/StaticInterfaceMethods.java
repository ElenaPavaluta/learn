package chapters.c5_class_design.implementingInterfaces.staticInterfaceMethods;

/**
 * 1. Like all methods in an interface, a static method is assumed to be public
 * and will not compile if marked as private or protected.
 * 
 * 2. To reference the static method, a reference to the name of the interface
 * must be used.
 *
 */
public interface StaticInterfaceMethods {

	default void defaultMethod() {
		System.out.println("interface default method");
	}

	static void staticMethod() { // assumed public, as all the methods in an
									// interface are
		System.out.println("interface static method");
	}
}

class SIMC implements StaticInterfaceMethods {

	public static void main(String[] args) {

		/*
		 * compiler error: Static interface methods are not inherited by a class
		 * implementing the interface.
		 * 
		 */
		// new SIMC().staticMethod();

		/*
		 * To reference the static method, a reference to the name of the
		 * interface must be used
		 */
		StaticInterfaceMethods.staticMethod();
	}
}
