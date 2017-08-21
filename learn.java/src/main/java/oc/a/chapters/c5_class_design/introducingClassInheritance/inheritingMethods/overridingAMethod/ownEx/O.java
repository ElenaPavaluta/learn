package oc.a.chapters.c5_class_design.introducingClassInheritance.inheritingMethods.overridingAMethod.ownEx;

public class O {

	A m(int a) throws ExceptionA {
		System.out.println("O");
		return new A();
	}
	
	
	static A ms() throws ExceptionA{
		System.out.println("O ms");
		return new A();
	}
}
