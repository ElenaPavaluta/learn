package oc.a.chapters._5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.overload;

import oc.a.chapters._5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.A;
import oc.a.chapters._5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.I;

public interface IB {

	public default I m(){
		return new A();
	}

}
