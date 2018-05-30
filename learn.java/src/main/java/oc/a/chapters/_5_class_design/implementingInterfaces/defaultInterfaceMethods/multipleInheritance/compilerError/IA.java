package oc.a.chapters._5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.compilerError;

public interface IA {

	default void m(){
		System.out.println("IA m");
	}
}
