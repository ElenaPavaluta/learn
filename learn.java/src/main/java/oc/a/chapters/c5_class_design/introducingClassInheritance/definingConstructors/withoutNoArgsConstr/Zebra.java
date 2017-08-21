package oc.a.chapters.c5_class_design.introducingClassInheritance.definingConstructors.withoutNoArgsConstr;

/**
 * 
 * Compiler error: Implicit super constructor Animal() is undefined for default
 * constructor. Must define an explicit constructor
 *
 */
public class Zebra extends Animal {

	private Zebra(int age) {
		super(age);
	}

	public static void main(String[] args) {
		Zebra z = new Zebra(5);
	}
}
