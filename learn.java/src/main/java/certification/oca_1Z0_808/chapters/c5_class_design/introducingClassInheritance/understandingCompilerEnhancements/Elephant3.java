package chapters.c5_class_design.introducingClassInheritance.understandingCompilerEnhancements;

/**
 * This code compiles because we have added a constructor with an explicit call
 * to a parent constructor.
 * 
 */
class Elephant3 extends Mammal {

	public Elephant3() {
		super(3);
	}
}
