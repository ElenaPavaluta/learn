package oc.a.chapters.c5_class_design.introducingClassInheritance.definingConstructors.withoutNoArgsConstr;

public class Animal {

	private int age;

	public Animal(int age) {
//		super();  //it's not required: the compiler will automatically insert it
		this.age = age;
	}

}
