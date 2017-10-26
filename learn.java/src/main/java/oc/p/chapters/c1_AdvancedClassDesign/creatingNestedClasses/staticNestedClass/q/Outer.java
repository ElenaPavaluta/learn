package oc.p.chapters.c1_AdvancedClassDesign.creatingNestedClasses.staticNestedClass.q;

class Outer
{
	private String outerFromStaticInner = StaticInner.staticInner;
	private String outerFromInner = new Inner().inner;
	private String outer = "outer";


	class Inner{
		String inner = "inner";
		String innerFromOuter = outer;
	}

	static class StaticInner
	{
		static String staticInner = "staticInner";
		String innerFromOuter = new Outer().outer;
 	}

	public static void main(String[] args)
	{
		Outer o = new Outer();
		StaticInner oi = new StaticInner();
//		oi = new o.Inner();  //not allowed

		Inner i =  o.new Inner();
		i = new Outer().new Inner();
	}
}
