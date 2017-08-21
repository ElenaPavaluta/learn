package oc.a.chapters.c5_class_design.implementingInterfaces.staticInterfaceMethods;

interface IB {  //assumed abstract. reminder a top level interface or class can only be public or package

	static void m(){  //assumed public
		System.out.println("static method m in IB");
	}
}
