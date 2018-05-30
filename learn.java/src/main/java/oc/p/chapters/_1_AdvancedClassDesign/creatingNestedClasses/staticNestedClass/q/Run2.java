package oc.p.chapters._1_AdvancedClassDesign.creatingNestedClasses.staticNestedClass.q;

class Run2
{
	void m()
	{
		Outer.StaticInner osi = new Outer.StaticInner();
	}

	void m2()
	{
		Outer.Inner oi = new Outer().new Inner();
	}
}
