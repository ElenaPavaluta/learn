package oc.a.chapters._4_methods_and_encapsulation.applyingAccessModifiers;

/**
 * The static initializer runs when the class is first used.
 *
 */
class StaticInitialization {

	private static final int NUM_SECONDS_PER_HOUR;

	static {
		int numSecondsPerMinute = 60;
		int numMinutesPerHour = 60;
		NUM_SECONDS_PER_HOUR = numSecondsPerMinute * numMinutesPerHour;
	}

	public StaticInitialization() {
		// NUM_SECONDS_PER_HOUR = 20; // compiler error
	}

}

class Example2 {
	private static int one;
	private static final int two;
	private static final int three = 3;
	// private static final int four; //compiler error. the for variable never
	// gets initialized

	static {
		one = 1;
		two = 1;
		// three = 3; //compiler error
		// two = 4; //compiler error
		one = 11;
	}

}
