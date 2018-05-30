package oc.a.chapters._5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance;

public interface I {

	void m();
	
	default A i(){
		return new A();
	}
}
