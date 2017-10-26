package oc.p.chapters.c1_AdvancedClassDesign.creatingNestedClasses.staticNestedClass.q;

import static oc.p.chapters.c1_AdvancedClassDesign.creatingNestedClasses.staticNestedClass.q.Outer.StaticInner;


class Run
{
	static void m()
	{
		StaticInner si = new StaticInner();
		System.out.println(si.innerFromOuter);
		System.out.println(si.staticInner);  // both ok, second prefered
		System.out.println(StaticInner.staticInner);
	}

	static void m2()
	{
		Outer.Inner oi = new Outer().new Inner();
		System.out.println(oi.innerFromOuter);
		System.out.println(oi.inner);
	}
}
