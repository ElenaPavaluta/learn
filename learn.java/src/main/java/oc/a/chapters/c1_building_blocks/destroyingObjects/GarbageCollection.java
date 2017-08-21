package oc.a.chapters.c1_building_blocks.destroyingObjects;

import java.util.Date;

public class GarbageCollection {

	static void m() {
		/*
		 * It's a suggestion that this might be a good moment for the Java to
		 * run the garbage collector mechanism. Java is free to ignore the
		 * request
		 */
		System.gc();
	}

	/*
	 * An object is no longer reachable when one of two situations occurs: ■ The
	 * object no longer has any references pointing to it. ■ All references to
	 * the object have gone out of scope.
	 */
	static void m2() {
		Date d = new Date();
		d = null; // the object declared on the above line lost his reference to
					// it
	}

	static void m3() {
		Date d = new Date(); // once this method get's executed and the jvm
								// continues with the
								// program execution, the object instantiated
								// here may be garbage collected
	}
}
