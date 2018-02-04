package oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.bounds.wildcardGenericType.wildcards.unbounded;

import oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.Robot;
import oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.Robot2;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


class Unbounded
{
	List lo = new ArrayList();

	List<?> l = new ArrayList<>();

	{
		lo.add(new StringBuilder());
		lo.add(LocalDateTime.now());
		lo.add(new ClassCastException());

//		l.add(new Robot());  //compiler error
//		String s  =l.get(0);  //compiler error

//		l.add((Object) new Robot());  //compiler error
	}

	static void print(List<?> l){
		for(Object o: l){
			System.out.println(o);
		}
	}


	public static void main(String[] args)
	{
		List<String> l = new ArrayList<>();
		l.add("a");
		l.add("b");
		print(l);

		List<Robot> lr = new ArrayList<>();
		lr.add(new Robot2());
		lr.add(new Robot());
		print(lr);
	}
}
