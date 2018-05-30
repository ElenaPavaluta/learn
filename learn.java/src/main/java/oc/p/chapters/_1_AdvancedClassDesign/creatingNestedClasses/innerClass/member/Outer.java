package oc.p.chapters._1_AdvancedClassDesign.creatingNestedClasses.innerClass.member;

/**
 * A member inner class is defined at the member level of a class (the same level as the methods,
 * instance variables, and constructors). Member inner classes have the following properties:
 * ■■ Can be declared public, private, or protected or use default access
 * ■■ Can extend any class and implement interfaces
 * ■■ Can be abstract or final
 * ■■ Cannot declare static fields or methods
 * ■■ Can access members of the outer class including private members
 */
class Outer
{
	private String s;


	protected interface I
	{
		void m();
	}

	interface I2
	{
	}

	private interface I3
	{
	}


	protected class MIC extends Abstr
	{
		//		static String micS2;  //compiler error
		//		static void m(){}  //compiler error

		protected MIC(){
			super("MIC");
		}
	}

	class MIC2 extends Abstr
	{
		MIC2(){
			super("MIC2");
		}
	}

	private class MIC3 extends Abstr
	{
		private MIC3(){
			super("MIC3");
		}
	}

	abstract class Abstr implements I
	{
		protected Abstr(String s)
		{
			Outer.this.s = s;
		}

		@Override public void m()
		{
			System.out.println(s);
			Outer.this.s ="new value";
		}
	}

	final class Final extends Abstr
	{
		public Final()
		{
			super("Final");
		}
	}
}
