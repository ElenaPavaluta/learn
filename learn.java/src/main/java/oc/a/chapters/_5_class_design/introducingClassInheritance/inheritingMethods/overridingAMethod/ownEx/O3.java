package oc.a.chapters._5_class_design.introducingClassInheritance.inheritingMethods.overridingAMethod.ownEx;

public class O3 extends O2{

	public final B m(int a){
		System.out.println("O3");
		return new B();
	}
	
	//static method hiding
	static B ms(){
		System.out.println("O3 ms");
		return new B();
	}
}
