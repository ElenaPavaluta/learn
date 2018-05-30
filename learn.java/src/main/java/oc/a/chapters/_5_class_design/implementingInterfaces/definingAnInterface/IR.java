package oc.a.chapters._5_class_design.implementingInterfaces.definingAnInterface;

/**
 * 
 * 1. Interfaces cannot be instantiated directly.
 * 
 * 2. An interface is not required to have any interfaceMethods.
 * 
 * 3. An interface may not be marked as final.
 * 
 * 4. All top-level interfaces are assumed to have public or defaulT access, and
 * they must include the abstract modifier in their definition. Therefore,
 * marking an interface as private, protected, or final will trigger a compiler
 * error, since this is incompatible with these assumptions.
 * 
 * 5. All nondefault interfaceMethods in an interface are assumed to have the modifiers
 * abstract and public in their definition. Therefore, marking a method as
 * private, protected, or final will trigger
 */
public abstract interface IR {  

	public static final int IRI = 007;  
	
	public abstract void m();
}
