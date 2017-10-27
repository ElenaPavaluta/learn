package oc.p.chapters.c1_AdvancedClassDesign.workingWithEnums.addingContructorFieldsMethods;

//import static oc.p.chapters.c1_AdvancedClassDesign.workingWithEnums.addingContructorFieldsMethods.Outer.E;  //redundant
// import due to the fact that already an E exists, and we need to solve this conflict

import static oc.p.chapters.c1_AdvancedClassDesign.workingWithEnums.addingContructorFieldsMethods.Outer.E2;


class Run
{
	void m()
	{
		//		E e = new E(false);  //compiler error: an enum can not be instantiated or extended
	}

	void m2()
	{
		Outer.E.E_1.i();
	}

	void m3()
	{
		E2.E2_1.i();
	}
}
