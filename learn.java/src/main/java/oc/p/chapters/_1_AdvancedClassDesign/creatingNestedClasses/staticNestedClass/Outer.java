package oc.p.chapters._1_AdvancedClassDesign.creatingNestedClasses.staticNestedClass;

/**
 * The nesting creates a namespace because the enclosing class dishName must be used to refer
 * to it.
 * ■■ It can be made private or use one of the other access modifiers to encapsulate it.
 * ■■ The enclosing class can refer to the fields and methods of the static nested class.
 */
class Outer
{
	private static String b = "b";
	private String a = "a";

	static void staticM()
	{
//		System.out.println(a);  //compiler error
		System.out.println(b);
//		System.out.println(c);  //compiler error
		System.out.println(new Nested().c);
//		System.out.println(d);  //compiler error
		System.out.println(Nested.d);
	}

	void m()
	{
		System.out.println(a);
		System.out.println(b);
		//		System.out.println(c); //compiler error
		System.out.println(new Nested().c);
		//		System.out.println(d);  //compiler error: the variable isn't vizible in the outer class
		System.out.println(Nested.d);
	}

	static class Nested
	{
		private static String d = "d";
		private String c = "c";

		static void staticNestedM()
		{
			//			System.out.println(c);  //compiler error: c is not static
			System.out.println(d);
		}

		void nestedM()
		{
			System.out.println(c);
			System.out.println(d);
		}
	}
}
