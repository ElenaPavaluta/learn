package oc.a.chapters.c3_core_java_apis.arrayList.operations;

import java.util.ArrayList;
import java.util.List;

/**
 * E remove(int index)
 * 
 * boolean remove(Object o):
 * 
 */
public class Remove {

	static List<Integer> lst;
	static {
		lst = new ArrayList<>();
		lst.add(1);
		lst.add(2);
		lst.add(2);
		lst.add(2);
		lst.add(3);
		lst.add(5);
		lst.add(7);
	}

	static void m() {
		Integer i = lst.remove(1);
		System.out.println(i);

		i = lst.remove(1);
		System.out.println(i);

		System.out.println(lst);
	}

	static void m2() {
		boolean b;
		
		// b = lst.remove(2); //compiler error: 2 it's primitive, and our lst
		// contains Integer
		
		b = lst.remove(new Integer(2));
		System.out.println(b);
		System.out.println(lst);
	}
	
	static void m3(){
		int i = lst.remove(26);  //throws IndexOutOfBoundsException
	}

	public static void main(String[] args) {
		m();
		m2();
		m3();
	}

}
