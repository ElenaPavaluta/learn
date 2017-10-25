package oc.p.chapters.c1_AdvancedClassDesign.creatingNestedClasses.innerClass.anonynous;

class Outer
{
	private I i = new I()
	{
		@Override public void i()
		{
			System.out.println("i");
		}
	};

	private Abstr abstr = new Abstr()
	{
	};

	static void m(I i, Abstr abstr)
	{
		i.i();
		abstr.abstr();
	}

	static void m2()
	{
		m(new I()
		{
			@Override public void i()
			{
				System.out.printf("m2 i");
			}
		}, new Abstr()
		{
			@Override void abstr()
			{
				System.out.println("m2 abstr");
			}
		});
	}

	public static void main(String[] args)
	{
		Outer o = new Outer();
		o.i.i();
		o.abstr.abstr();
		m2();
	}
}
