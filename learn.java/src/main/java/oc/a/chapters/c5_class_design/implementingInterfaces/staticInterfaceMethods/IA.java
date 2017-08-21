package oc.a.chapters.c5_class_design.implementingInterfaces.staticInterfaceMethods;

abstract interface IA {

	static void m(){  //assumed public
		System.out.println("static method m in IA");
	}
}
