package oc.a.chapters._3_core_java_apis.arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertingBetweenArrayAndList {

	static void remember() {
		int[] a = new int[] {};
		int[] a2 = {};
		int[] a3 = new int[3];
		int[] a4;
		// a4 = {};
		a4 = new int[] {};
	}

	// list to array
	static void m() {
		List<String> lst = new ArrayList<String>();

		lst.add("hawk");
		lst.add("robin");

		Object[] oa = lst.toArray();
		System.out.println(oa.length); // 2

		String[] sa = lst.toArray(new String[0]);
		System.out.println(sa.length); // 2 The advantage of specifying a size
										// of 0 for the parameter is that Java
										// will create a new array of the proper
										// size for the return value. If you
										// like, you can suggest a larger array
										// to be used instead. If the ArrayList
										// fits in that array, it will be
										// returned. Otherwise, a new one will
										// be created.
		sa[0] = "Jhony Bravo";
		System.out.println(lst); // the original arraylist it's not affected by
									// the change in the array

		for (String s : sa) {
			System.out.print(s + "\t");
		}
	}

	// array to list
	/*
	 * The original array and created array backed List are linked
	 */
	static void m2() {
		String[] array = { "hawk", "robin" }; // [hawk, robin]
		List<String> lst = Arrays.asList(array); // returns fixed size list.
													// Note that it isn�t the
													// java.util.ArrayList we�ve
													// grown used to. It is a fi
													// xed-size, backed version
													// of a List.

		// lst.add("new String"); //java.lang.UnsupportedOperationException
		
//		lst.set(0, "new String");  //java.lang.UnsupportedOperationException

		System.out.println(lst.size()); // 2

		lst.set(0, "Jhony Bravo");

		System.out.println(array[0]); // Jhony Bravo

		array[1] = "has a horse";

		System.out.println(lst);

		lst.remove(0); // java.lang.UnsupportedOperationException
	}

	// with varargs
	static void m3() {
		List<String> lst = Arrays.asList("ana", "are", "mere");
		// lst.add("another String"); //java.lang.UnsupportedOperationException
	}

	public static void main(String[] args) {
		// m();
		 m2();
//		m4();
	}
}
