package oc.p.chapters.c1_AdvancedClassDesign.creatingNestedClasses.innerClass.member;

class OuterVar
{
	private static String staticOuter = "staticOuter";
	private String outer = "outer";

	void m()
	{
		new Inner().innerM();
	}

	private void m2(){
		System.out.println("private void m2");
	}

	private static void m3(){}

	class Inner
	{
		private String inner = "inner";
		//		private static String staticInner = "staticInner";  //inner classes can not have static variables or methods
		//		private static void m(){}

		void innerM(){
			m2();
		}

		private String inner2 = OuterVar.this.outer;

		void innerM2(){
			OuterVar.m3();
		}
	}
}
