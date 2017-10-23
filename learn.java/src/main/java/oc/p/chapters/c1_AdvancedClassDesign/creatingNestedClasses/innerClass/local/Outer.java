package oc.p.chapters.c1_AdvancedClassDesign.creatingNestedClasses.innerClass.local;

/**
 * ■ They do not have an access specifier.
 * ■ They cannot be declared static and cannot declare static fields or methods.
 * ■ They have access to all fields and methods of the enclosing class.
 * ■ They do not have access to local variables of a method unless those variables are final or effectively final.
 *
 *
 * The compiler is generating a class file from your
 * inner class. A separate class has no way to refer to local variables. If the local variable is final ,
 * Java can handle it by passing it to the constructor of the inner class or by storing it in the class
 * fi le. If it weren’t effectively fi nal, these tricks wouldn’t work because the value could change
 * after the copy was made.
 */
class Outer
{
	private int height = 5;

	public static void main(String[] args)
	{
		new Outer().calculate();
	}

	public void calculate()
	{
		final int width = 5;

		int effectiveFinal = 5;

		int notEffectiveFinal = 4;
		notEffectiveFinal++;

		int notEffectiveFinal2 = 4;

		//these classes don't have an access specifier
		class Inner implements I
		{

			@Override public int comp()
			{
				int res = height + width + effectiveFinal;
				//				res = res + notEffectiveFinal;  //compiler error: not efective final variable
				//				res = res + notEffectiveFinal2;  //compiler error: not effective final variable
				return res;
			}
		}

		Inner in = new Inner();
		int res = in.comp() + effectiveFinal + notEffectiveFinal + ++notEffectiveFinal2;
		System.out.println(res);

	}

	private interface I
	{
		int comp();
	}
}
