package oc.a.chapters.c3_core_java_apis.javaArrays.creatingAnArrayOReferenceVariables;

import java.util.Arrays;

public class Array {

	static void m() {
		String[] bugs = { "cricket", "beetle", "ladybug" };
		String[] alias = bugs;

		System.out.println(bugs == alias); // true
		System.out.println(bugs.equals(alias)); // true; due to reference
												// equality, but the equals
												// method it't not defined for
												// arrays
		System.out.println(bugs.toString());

		System.out.println(Arrays.toString(bugs));
	}

	static void m2() {
		String names[] = new String[2]; // String is an object, so the elements
										// here will be initialized to null
		System.out.println(Arrays.toString(names));
	}

	static void m3() {
		String[] string = { "stringValue" };
		Object[] objects = string;
		String[] againString = (String[]) objects;

		objects[0] = new StringBuilder(); // From the point of view of the
											// compiler, this is just fine. A
											// StringBuilder object can clearly
											// go in an Object[]. The problem is
											// that we don�t actually have an
											// Object[]. We have a String[]
											// referred to from an Object[]
											// variable. At runtime, the code
											// throws an ArrayStoreException

		// againString[0] = new StringBuilder(); //compiler error
	}

	public static void main(String[] args) {
		 m();
		// m2();
//		m3();
	}
}
