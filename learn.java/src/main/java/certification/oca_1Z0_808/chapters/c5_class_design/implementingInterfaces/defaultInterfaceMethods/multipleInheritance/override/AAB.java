package chapters.c5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.override;

import chapters.c5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.C;

public abstract class AAB implements IA, IB{

	/**
	 * The overriden method needs to respect the override rules for both the method in IA and IB 
	 */
//	@Override  //compiler error
//	public C m() throws Exception {
//		return new C();
//	}

	@Override  //this is a correct override method
	public C m(){
		return new C();
	}
	
}
