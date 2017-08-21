package oc.a.chapters.c4_methods_and_encapsulation.encapsulatingData.immutableClasses;

/**
 * Remember, immutable is only measured after the object is constructed.
 * Immutable classes are allowed to have values. They just can't change after
 * instantiation
 *
 */
public class ImutableClass {

	private StringBuilder sb;

	public ImutableClass(StringBuilder sb) {
		this.sb = sb;
	}

	public StringBuilder getSb() {
		return new StringBuilder(sb); // defensive copy
	}

}
