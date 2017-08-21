package oc.a.chapters.c5_class_design.introducingClassInheritance.definingConstructors.withNoArgConstructor;

/**
 * 
 * Because there is a no argument constructor in the super class the compiler
 * doesn't complain for not providing a constructor with arguments (meaning that
 * it's not a compiler error, as it would be other wise)
 * 
 * But I I define a constructor with arguments, if I still want to use the no
 * args constructor I need to provide a no args constructor explicitly
 * 
 */
public class Zebra extends Animal {

	// public Zebra(int a, int b){
	// super(a+b);
	// }

	public static void main(String[] args) {
		Zebra z = new Zebra();
	}
}
