package oc.p.chapters._1_AdvancedClassDesign.usingInstanceof;

import java.time.LocalDate;


/**
 * The compilation check only applies when instanceof is called on a class. When checking
 * whether an object is an instanceof an interface, Java waits until runtime to do the
 * check. The reason is that a subclass could implement that interface and the compiler
 * wouldn’t know it.
 */
class InstanceOf
{
	static void m()
	{
		System.out.println(null instanceof String); //false

		//		System.out.println(LocalDate.now() instanceof null);  //compiler error

		System.out.println("a" instanceof Object);  //true

		LocalDate ld = null;
		System.out.println(ld instanceof Object);  //false

		ld = LocalDate.now();
		System.out.println(ld instanceof Object);  //true
	}

	public static void main(String[] args)
	{
		m();
	}
}
