package oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.cantDoWithGenerics;

/**
 * Call the constructor. new T() is not allowed because at runtime it would be new Object().
 *
 *
 * Create an array of that static type. This one is the most annoying, but it makes sense
 * because you’d be creating an array of Objects.
 *
 *
 * Call instanceof. This is not allowed because at runtime List<Integer> and
 * List<String> look the same to Java thanks to type erasure.
 *
 *
 * Use a primitive type as a generic type parameter. This isn’t a big deal because you
 * can use the wrapper class instead. If you want a type of int, just use Integer.
 *
 *
 * Create a static variable as a generic type parameter. This is not allowed because the
 * type is linked to the instance of the class.
 *
 */

class NotAllowed<T>
{
	T t;

	{
//		t = new T();  //compiler error

//	T[] ts = new T[2];  //compiler error

//		t instanceof T;  //compiler error
	}


//	static T st;  //compiler error


}
