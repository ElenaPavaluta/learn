package oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.bounds.wildcardGenericType.wildcards.unbounded;

import oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.Robot;
import oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.Robot2;
import java.util.ArrayList;
import java.util.List;


class Need
{
	{
		List<Robot2> lr2 = new ArrayList<>();

		//	List<Robot> lr = lr2;  //compiler error.

		//		List<Robot> lr = (List<Robot>)lr2;  //compiler error: incompatible types

		//		List<Object> lo = lr2;  //compiler error

		//		List<Object> lo = (List<Object>) lr2;  //compiler error: incompatible types

		/**
		 * Although Robot2 is a subclass of Robot, List<Robot2>
		 *    can not be assigned to List<Robot> or List<Object>
		 */
	}

	{
		Robot2[] ar2 = new Robot2[] { new Robot2(), new Robot2() };

		Robot[] ar;

		Object[] ao;

		String[] as;

		ar = ar2;
		ao = ar2;
		as = (String[]) ao;  //ClassCastException/ ExceptionInInitializerError if the block was static

	}



	public static void main(String[] args)
	{
		new Need();
	}

}
