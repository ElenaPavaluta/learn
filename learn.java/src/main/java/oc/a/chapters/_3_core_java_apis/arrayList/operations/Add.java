package oc.a.chapters._3_core_java_apis.arrayList.operations;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * public boolean add(E e) //return always true
 * 
 * public void add(int index, E element)
 */

public class Add {

	static void m(){
		ArrayList a = new ArrayList();
		
		a.add("hawk");
		a.add(Boolean.TRUE);
		
		System.out.println(a);
	}
	
	static void m2(){
		List<String> birds = new ArrayList<>();
		birds.add("hawk");
		birds.add(1, "robin");
		birds.add(0, "blue jay");
		birds.add(1, "cardinal");
		System.out.println(birds);
	}
	
	static void m3(){
		List<String> lst = new ArrayList<>();
		lst.add(1, "IndexOutOfBoundsException");  //theows IndexOutOfBoundsException
	}
	
	public static void main(String[] args) {
//		m();
		m2();
//		m4();
	}
}
