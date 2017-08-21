package oc.a.chapters.c5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.overload;

import oc.a.chapters.c5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.B;
import oc.a.chapters.c5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.C;
import oc.a.chapters.c5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.I;

public class CAB2 extends AAB {

	@Override
	public void m(B b, C c) {
		// TODO Auto-generated method stub
		super.m(b, c);
	}

	@Override
	public I m(I i) {
		// TODO Auto-generated method stub
		return super.m(i);
	}

	@Override
	public I m() {
		// TODO Auto-generated method stub
		return super.m();
	}

}
