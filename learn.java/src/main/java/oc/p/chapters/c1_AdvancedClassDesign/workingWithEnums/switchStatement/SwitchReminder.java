package oc.p.chapters.c1_AdvancedClassDesign.workingWithEnums.switchStatement;

/**
 * Data types supported by switch statements include the following:
 * int and Integer
 * byte and Byte
 * short and Short
 * char and Character
 * int and Integer
 * String
 * enum values
 * The values in each case statement must be compile-time constant values of the
 * same data type as the switch value. This means you can use only literals,
 * enum constants, or final constant variables of the same data type.
 */
class SwitchReminder
{
	final int five = 5;
	final int six = 6;

	public static void main(String[] args)
	{
		SwitchReminder sr = new SwitchReminder();
				sr.m2();  //default 6
				sr.m3();  //6
				sr.m4(); //5 bla
	}

	void m(int i)
	{
		int a = 0;
		int b;
		switch (i)
		{
			default:
				System.out.println("default ");
			case six:
				System.out.println(six);
				break;
			case five:
			{  //not obligatory to use {}
				System.out.println(five);
				System.out.println(" bla");
			}
			break;
//			case a:  //compiler error: needs to be a constanst
//			case b:  //compiler error: needs to be initialized
		}
	}

	void m2()
	{
		m(4);
	}

	void m3()
	{
		m(six);
	}

	void m4()
	{
		m(five);
	}
}
