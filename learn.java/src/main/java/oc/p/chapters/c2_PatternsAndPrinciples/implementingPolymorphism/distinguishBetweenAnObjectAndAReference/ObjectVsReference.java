package oc.p.chapters.c2_PatternsAndPrinciples.implementingPolymorphism.distinguishBetweenAnObjectAndAReference;


/**
 * 1. The type of the object determines which properties exist within the object in memory.
 *
 * 2. The type of the reference to the object determines which methods and variables are accessible to the Java program.
 */
class ObjectVsReference
{
	int i = 3;
	void instM(){}

	interface I
	{
		static int staticInt =7;

		static void staticM(){
		}

		default void defaultM(){
		}

		void m();
	}

	abstract class AC{
		abstract void acM();
	}

	class C extends AC implements I{
		@Override public void m()
		{
			i = 9;
			instM();

			ObjectVsReference.this.i = 007;
			this.defaultM();
			this.acM();
//			this.m();  //ok, but recursive call

//		 	super.acM();  //can not be accessed directly

			System.out.println(this.staticInt);
			System.out.println(I.staticInt);
			I.staticM();
		}

		@Override void acM()
		{
		}
	}

	static void m(){
		ObjectVsReference or = new ObjectVsReference();
		ObjectVsReference.I i = or. new C();

		i.m();
		i.defaultM();
		ObjectVsReference.I.staticM();

		ObjectVsReference.AC ac = (ObjectVsReference.AC)i;
		ac.acM();

		ObjectVsReference.C c = (ObjectVsReference.C)i;
		c = (ObjectVsReference.C)ac;
		c.m();
		c.defaultM();
		c.acM();
	}

	public static void main(String[] args)
	{
		m();
	}
}
