package oc.a.chapters.c4_methods_and_encapsulation.applyingAccessModifiers;

import java.util.ArrayList;

/**
 * We are allowed to call interfaceMethods on reference variables. All the compiler can
 * do is check that we don�t try to reassign the final values to point to a
 * different object.
 *
 */
public class StaticVariables {

	private static final int NUM_BUCKETS = 45;

	private static final ArrayList<String> values = new ArrayList<>();
	
	
	static void m(){
		values.add("changed"); //
		System.out.println(values.get(0)); // changed
	}

	
	static void m2(){
//		values = new ArrayList<String>();  //Compile time error
	}
	
	public static void main(String[] args) {
		m();
		m2();
	}
}
