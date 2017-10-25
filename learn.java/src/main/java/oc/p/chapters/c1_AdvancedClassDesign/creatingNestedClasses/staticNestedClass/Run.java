package oc.p.chapters.c1_AdvancedClassDesign.creatingNestedClasses.staticNestedClass;

class Run
{
	Outer o = new Outer();

	void m(){
		o.m();
		o.staticM();
	}

	void m2(){
		Outer.Nested on = new Outer.Nested();

		on.nestedM();
		on.staticNestedM();
	}

	void m3(){
		Outer.staticM();
		Outer.Nested.staticNestedM();
	}

	static void m4(){
		Outer.staticM();
		Outer.Nested.staticNestedM();
	}

	public static void main(String[] args)
	{
		m4();
	}
}
