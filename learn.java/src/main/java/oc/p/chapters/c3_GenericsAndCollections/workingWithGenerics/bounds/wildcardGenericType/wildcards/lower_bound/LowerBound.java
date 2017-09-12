package oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.bounds.wildcardGenericType.wildcards.lower_bound;

import java.util.ArrayList;
import java.util.List;


class LowerBound
{
	List<String> strings = new ArrayList<>();
	{
		strings.add("tweet");
	}

	List<Object> objects = new ArrayList<>(strings);

	{
		addSound5(strings);
		addSound5(objects);
	}

	/*
		These methods can't be overloaded because they have the same erasure type
	 */
	void addSound(List l){  //ok
		l.add("sound");
		System.out.println(l);
	}

	void addSound2(List<Object> l){
		l.add("sound");
	}

	void addSound3(List<?> l){
//		l.add("sound");  //compiler error: l is logically imutable; remove works
	}

	void addSound4(List<? extends  Object> l){
//		l.add("sound");  //compiler error: l is logically imutable; remove works
	}

	void addSound5(List<? super  String> l){
		l.add("sound");
		System.out.println(l);
	}

	public static void main(String[] args)
	{
		new LowerBound();
	}
}
