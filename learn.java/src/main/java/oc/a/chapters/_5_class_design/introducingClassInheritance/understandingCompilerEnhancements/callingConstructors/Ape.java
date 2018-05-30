package oc.a.chapters._5_class_design.introducingClassInheritance.understandingCompilerEnhancements.callingConstructors;

public class Ape extends Primate{

	public Ape() {
		super();
//		super();  //work both with and without the super call; keep in mind that the super class has a defined no arg constructor
		System.out.println("Ape");
	}

	
}
