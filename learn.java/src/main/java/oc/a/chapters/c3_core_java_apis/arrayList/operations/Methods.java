package oc.a.chapters.c3_core_java_apis.arrayList.operations;

import java.util.ArrayList;
import java.util.List;

/**
 * boolean contains(Object object)
 * 
 * boolean contains(Object object)
 * 
 * boolean isEmpty()
 * 
 * int size()
 * 
 * void clear()
 *
 */
public class Methods {

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
		System.out.println(lst.contains(007)); // true
		System.out.println(lst.contains(0xA)); // false
	}

	static void m2() {
		ArrayList<Integer> arri = new ArrayList<>();
		arri.add(1);
		arri.add(2);
		arri.add(3);
		arri.add(5);
		arri.add(7);
		System.out.println(lst.equals(arri)); // true
		arri.add(0b01, 0b01);
		System.out.println(lst.equals(arri)); // false
	}

	static void m3() {
		m4();
		lst.clear();
		m4();
	}

	static void m4() {
		System.out.println(lst.isEmpty()); // false; true
		System.out.println(lst.size()); // 5; 0

	}

	public static void main(String[] args) {
		m();
		m2();
		// m4();
	}
}
