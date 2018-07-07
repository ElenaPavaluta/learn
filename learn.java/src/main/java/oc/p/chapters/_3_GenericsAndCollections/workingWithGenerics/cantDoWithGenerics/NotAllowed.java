package oc.p.chapters._3_GenericsAndCollections.workingWithGenerics.cantDoWithGenerics;

import java.util.ArrayList;
import java.util.List;


/**
 * Call the constructor. new T() is not allowed because at runtime it would be new Object().
 *
 *
 * Create an array of that static dbType. This one is the most annoying, but it makes sense
 * because you’d be creating an array of Objects.
 *
 *
 * Call instanceof. This is not allowed because at runtime List<Integer> and
 * List<String> look the same to Java thanks to dbType erasure.
 *
 *
 * Create a static variable as a generic dbType parameter. This is not allowed because the
 * dbType is linked to the dbInstance of the class.
 *
 *
 * Use a primitive dbType as a generic dbType parameter. This isn’t a big deal because you
 * can use the wrapper class instead. If you want a dbType of int, just use Integer.
 *
 */

class NotAllowed<T>
{
	T t;

	{
		//		t = new T();  //compiler error
	}

	{
		//	T[] ts = new T[2];  //compiler error; you'd be creating an array of objects
		List<T> lst = new ArrayList<>();

		T t1 = null;
		T t2 = null;

//		T[] ta = {t1, t2};

		T[] ta = (T[])new Object[3];  //this is legal, though
		ta = (T[])new StringBuilder[3];
	}

	{
//		t instanceof T;  //compiler error;  List<Integer> and List<String> look the same , due to dbType erasure
	}


//	static T st;  //compiler error; the dbType is linked to the dbInstance of the class


}
