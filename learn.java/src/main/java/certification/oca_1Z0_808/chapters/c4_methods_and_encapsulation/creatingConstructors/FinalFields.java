package chapters.c4_methods_and_encapsulation.creatingConstructors;

/**
 * By the time the constructor completes, all final instance variables must have
 * been set.
 *
 */
public class FinalFields {

	// private static final int volume;
	// private final static int volume; //both are ok as definitions

	private final int vol;

	// 1.
	// private final int vol = 5;

	// 2.
	// {
	// vol = 5;
	// }

	public FinalFields() {
		vol = 005;
	}

}
