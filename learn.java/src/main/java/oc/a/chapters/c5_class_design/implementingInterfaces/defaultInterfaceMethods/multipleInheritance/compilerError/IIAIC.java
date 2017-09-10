package oc.a.chapters.c5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.compilerError;

/**
 * Compiler error if the methods with the same signature (either instance or default) is not redeclared
 */
interface IIAIC extends IA, IC
{
	//	void m();  //redeclare ok

	default void m()
	{
	} // ok, too
}

