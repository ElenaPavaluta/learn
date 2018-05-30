package oc.a.chapters._1_building_blocks.destroyingObjects;

/**
 * Reminder: All references have the same size, no matter of the object type
 * being referred
 */
class Scope {

	public static void main(String[] args) {
		String a, b;
		a = new String("a"); // a new object it's created which it's reachable
								// by the the a variable
		b = new String("b");// a new object it's created, which it's referred
							// by the b variable
		a = b; // the a variable now it's referring to the same object as
				// the b variable; the object reffered earlier by the a
				// variable it's now eligible to be garbage collected
		String c = a; // the object referenced by both a and be references it's
						// now also referred by the c reference
		a = null; // the a reference no longer points to any object
	}
}
