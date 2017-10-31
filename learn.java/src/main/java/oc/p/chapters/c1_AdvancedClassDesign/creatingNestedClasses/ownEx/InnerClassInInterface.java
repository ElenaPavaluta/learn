package oc.p.chapters.c1_AdvancedClassDesign.creatingNestedClasses.ownEx;

interface InnerClassInInterface
{
	interface I
	{
		void m();

		default void defaultM(){}

		static void staticM(){}
	}

	class AI implements I{
		@Override public void m()
		{

		}

		static int a = 0xa;

		static void staticMA(){}  //a inner class defined inside an interface can have both static variables and static methods,
		// but an inner class defined inside a class can not

		class AI2{
//			static int anInt = 3;  //inner classes cannot have static fields or methods
		}
	}

	static interface I2{  //static is redundant, but valid nevertheless
		void m();

		default void defaultM(){}

		static void staticM(){}
	}

	class BI2 implements I2{
		@Override public void m()
		{

		}

		static void staticMB(){}
	}
}
