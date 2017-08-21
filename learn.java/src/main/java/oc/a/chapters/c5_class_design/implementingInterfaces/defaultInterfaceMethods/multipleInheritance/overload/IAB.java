package oc.a.chapters.c5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.overload;

import oc.a.chapters.c5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.B;
import oc.a.chapters.c5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.C;

public interface IAB extends IA, IB{

	public default void  m(B b, C c){
		System.out.println("IAB m");
	}
}
