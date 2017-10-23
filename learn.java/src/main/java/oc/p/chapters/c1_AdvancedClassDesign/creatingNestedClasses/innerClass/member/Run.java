package oc.p.chapters.c1_AdvancedClassDesign.creatingNestedClasses.innerClass.member;

class Run
{
	Outer o = new Outer();

	public static void main(String[] args)
	{
		Run r = new Run();
		r.m();
		r.m2();
		r.m3();

		r.new A().m();
		new Run().new A().m();

		System.out.println(new Mic(). new Mic2(). new Mic3(). new Mic4().toString());
	}

	void m()
	{
		Outer.MIC omic = o.new MIC();
		omic = new Outer().new MIC();
		omic.m();

		//		o.MIC omic2  //compiler error;
	}

	void m2()
	{
		Outer.MIC2 omic2 = o.new MIC2();
		omic2 = new Outer().new MIC2();
		omic2.m();
	}

	void m3()
	{
		Outer.Final f = o.new Final();
		f = new Outer().new Final();
		f.m();
	}

	class A implements Outer.I
	{
		@Override public void m()
		{
			System.out.println("I");
		}
	}

	//	protected class B extends Outer.MIC{}  //compiler error: there's no instance of the outer class in order for the MIC to exists

	//	class C extends Outer.Abstr{  //compiler error: there's no instance of the outer class in order for the Abstr to exists
	//		public C(String s)
	//		{
	//			super(s);
	//		}
	//	}
}
