package oc.p.chapters._3_GenericsAndCollections.workingWithGenerics.bounds.wildcardGenericType.wildcards.lower_bound;

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
		addSoundRaw(strings);
		addSoundRaw(objects);
	}

	{
//		addSoundListOfObj(strings);  //compiler error List<Type> = List<SubType>
		addSoundListOfObj(objects);
	}

	{
		addSoundLowerBoundWildcard(strings);
		addSoundLowerBoundWildcard(objects);
	}

	/*
		These methods can't be overloaded because they have the same erasure dbType (Object)
	 */
	void addSoundRaw(List l){
		l.add("sound");
		System.out.println(l);
	}

	void addSoundListOfObj(List<Object> l){
		l.add("sound");
	}

	void addSoundUnboundedWildcard(List<?> l){
//		l.add("sound");  //compiler error: l is logically imutable; remove works
	}

	void addSoundUpperBoundWildcard(List<? extends  Object> l){
//		l.add("sound");  //compiler error: l is logically imutable; remove works
	}

	void addSoundLowerBoundWildcard(List<? super  String> l){
		l.add("sound");
		System.out.println(l);
	}

	public static void main(String[] args)
	{
//		new LowerBound();
//		System.out.println("a" + null);
		System.out.println(String.valueOf(null));
	}

}
