package chapters.c5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.overload;

import chapters.c5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.A;
import chapters.c5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.I;

public interface IA {

	public default I m(I i){
		return new A();
	}
}
