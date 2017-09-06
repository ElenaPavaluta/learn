package oc.a.chapters.c5_class_design.implementingInterfaces.staticInterfaceMethods;

class AIAIB implements IA, IB { // no compiler error: because the interface
								// static interfaceMethods are not inherited by the
								// implementing classes
	
	public static void main(String[] args) {
		
		IA.m();
		IB.m();
	}

}
