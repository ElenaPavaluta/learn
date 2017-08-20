package chapters.c5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.override;

import chapters.c5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.B;

public interface IB {

	default B m(){
		return new B();
	}
	
}
