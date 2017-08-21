package oc.a.chapters.c3_core_java_apis.arrayList.operations;

import java.util.ArrayList;
import java.util.List;

/**
 * public E set(int index, E element)
 * 
 * Replaces the element at the specified position in this list with the
 * specified element.
 * 
 * 
 * Returns: the element previously at the specified position
 *
 */
public class Set {

	static List<Integer> lst;
	static {
		lst = new ArrayList<>();
		lst.add(1);
		lst.add(2);
		lst.add(3);
		lst.add(5);
		lst.add(7);
	}

	static void m() {
		int i = lst.set(1, 9); // i=2;
		System.out.println(i);
		
		System.out.println(lst);
	}

	static void m2() {
		int i = lst.set(007, 27); // throws IndexOutOfBoundsException
	}

	public static void main(String[] args) {
		m();
//		m2();
	}
}
