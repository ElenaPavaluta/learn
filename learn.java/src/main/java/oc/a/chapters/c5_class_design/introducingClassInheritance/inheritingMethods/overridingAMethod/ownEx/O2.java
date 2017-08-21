package chapters.c5_class_design.introducingClassInheritance.inheritingMethods.overridingAMethod.ownEx;

public class O2 extends O{

	protected B m(int a) throws ExceptionB{
		System.out.println("O2");
		return new B();
	}
	
	//static method hiding
	static B ms() throws ExceptionB{
		System.out.println("O2 ms");
		return new B();
	}
}
