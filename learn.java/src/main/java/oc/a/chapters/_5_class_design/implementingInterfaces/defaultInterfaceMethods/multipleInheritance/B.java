package oc.a.chapters._5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance;

public class B extends A{

	@Override
	public B i() {
		return new B();
	}
	
}
