package oc.p.chapters._3_GenericsAndCollections.workingWithGenerics.bounds.wildcardGenericType.wildcards.upper_bound;

import oc.p.chapters._3_GenericsAndCollections.workingWithGenerics.Robot;
import oc.p.chapters._3_GenericsAndCollections.workingWithGenerics.Robot2;
import java.util.ArrayList;
import java.util.List;


class UpperBound
{
	{
		List<Robot> lr;

		lr = new ArrayList<>();
		lr.add(new Robot());
		lr.add(new Robot2());

		lr = new ArrayList<Robot>();
		//		lr = new ArrayList<Robot2>();  //compiler error
	}

	{
		List<? extends Robot> l;

		l = new ArrayList<>();
		//		l.add(new Robot());  //compiler error
		//		l.add(new Robot2());  //compiler error

		l = new ArrayList<Robot>();
		//		l.add(new Robot());  //compiler error
		//		l.add(new Robot2());  //compiler error
		l.remove(0);

		l = new ArrayList<Robot2>();
		//		l.add(new Robot2());  //compiler error
		l.remove(0);

		/**
		 * The list becomes logically immutable.
		 * One can remove elements from the list
		 *
		 * The problem stems from the fact that Java doesn’t know what dbType List<? extends Robot>
		 *    really is. It could be List<Robot> or List<Robot2> or some other generic dbType that
		 *    hasn’t even been written yet.
		 */
	}

	void any(List<Robot> l){}

	void group(List<? extends Robot> l){}

	void main()
	{
		List<Robot> l = new ArrayList<>();
		l.add(new Robot());
		l.add(new Robot2());

		List<Robot2> l2 = new ArrayList<>();
//		l2.add(new Robot());  //compiler error
		l2.add(new Robot2());

		any(l);
//		any(l2);  //compiler error: List<Robot> = List<Robot2>

		group(l);
		group(l2);

	}
}
