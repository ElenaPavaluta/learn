package oc.a.chapters.c5_class_design.implementingInterfaces.staticInterfaceMethods;

class C2 implements StaticInterfaceMethods {

	static void staticMethod() {
		System.out.println(
				"this is the reason why an interface static method can be accessed only using the name of the interface and not a reference to an implementing class");
	}

	public static void main(String[] args) {
		StaticInterfaceMethods.staticMethod();

		C2.staticMethod();
	}
}
