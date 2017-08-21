package chapters.c5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.override;

import chapters.c5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.A;

public interface IA {

	default A m() throws Exception{
		return new A();
	}
}
