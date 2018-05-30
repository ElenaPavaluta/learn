package oc.a.chapters._5_class_design.implementingInterfaces.staticInterfaceMethods;

abstract interface IA {

	static void m(){  //assumed public
		System.out.println("static method m in IA");
	}
}
