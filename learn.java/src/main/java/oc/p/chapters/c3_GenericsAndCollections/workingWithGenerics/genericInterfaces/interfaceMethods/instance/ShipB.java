package oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.genericInterfaces.interfaceMethods.instance;

import oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.Elephant;
import oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.Robot;
import oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.Robot2;
import java.sql.Date;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.TimerTask;


class ShipB implements Ship<Robot, Elephant>
{

	private static ShipB inst;
	private static Robot r;
	private static Elephant e;

	static
	{
		inst = new ShipB();
	}

	//T m(U u);
	static void m()
	{
		r = inst.m(e);
		r = inst.<Robot>m(e);
		/**
		 * It seems that the compiler just doesn't care about the type in <> if in the method declaration isn't specified
		 */
		r = inst.<DateTimeException>m(e);
		r = inst.<Elephant>m(e);
	}

	static void m_2()
	{
		//		String s = inst.m(e); //compiler error: A robot is expected as a return type
	}

	//<T> T m2(U u);
	static void m2()
	{
		r = inst.m2(e);
		r = inst.<Robot>m2(e);
		r = inst.<Robot2>m2(e);  //a derived class can also be used in this case
		//        r = inst.<Object> m2 (e);  //compiler error
		//        r = inst.<DateTimeException>m2 ( e );  //compiler error
		  /*
		  When the generic type is specified one ca either supply the right type(including subtypes), or none at all
         */
	}

	static void m2_2()
	{
		String s = inst.m2(e);
		s = inst.<String>m2(e);
		//        s = inst.<Robot> m2(e);  //compiler error: the specified generic type must be the same as the returned type, as the method's definition

		LocalDate ld = inst.m2(e);
		ld = inst.<LocalDate>m2(e);

		ArrayIndexOutOfBoundsException aioobe = inst.m2(e);
		aioobe = inst.<ArrayIndexOutOfBoundsException> m2(e);
	}

	//<V> V m3(T t, U u);
	static void m3()
	{
		Date d;

		d = inst.m3(r, e);
		d = inst.<Date>m3(r, e);

		String s = inst.m3(r, e);
		s = inst.<String>m3(r, e);

		//        s= inst.<Date> m3 ( r, e );  //compiler error: Return type and generic type must be the same
	}


//	public abstract <T, Q> T m4(U u, Q q);
	static void m4()
	{
		r = inst.m4(e, new StringBuilder());
		r = inst.<Robot, StringBuilder>m4(e, new StringBuilder());
	}


	static void m44()
	{
		TimerTask tt = inst.m4(e, new StringBuilder());
		tt = inst.<TimerTask, StringBuilder>m4(e, new StringBuilder());
	}

	@Override
	public Robot m(Elephant elephant)
	{
		return null;
	}

	@Override
	public <T> T m2(Elephant elephant)
	{
		return null;
	}

	@Override
	public <V> V m3(Robot robot, Elephant elephant)
	{
		return null;
	}

	@Override
	public <T, Q> T m4(Elephant elephant, Q q)
	{
		return null;
	}
}
