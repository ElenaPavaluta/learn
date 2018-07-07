package oc.a.chapters._5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.compilerError;

public interface IB {

	default int m(){
		System.out.println("IB createAndPopulate");
		return 1;
	}
}
