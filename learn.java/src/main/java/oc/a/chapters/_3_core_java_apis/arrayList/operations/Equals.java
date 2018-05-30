package oc.a.chapters._3_core_java_apis.arrayList.operations;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * ArrayList has a custom implementation of equals(): compares two lists to see
 * if they contain the same elements in the same order
 *
 */
public class Equals {

	static void m(){
		ArrayList<String> al = new ArrayList<String>();
		ArrayList<String> al2  = new ArrayList<String>();
		
		System.out.println(al.equals(al2));  //true
		
		al.add("a");
		System.out.println(al.equals(al2));  //false;
		
		al2.add("a");
		System.out.println(al.equals(al2));  //true
		
		al.add("b");
		al2.add(0, "b");
		System.out.println(al.equals(al2));  //false
		
	}
	
	static void m2(){
		ArrayList<StringBuilder> a = new ArrayList<>();
		System.out.println(a.equals(null));  //false
	}
	
	
	static void m3(){
		ArrayList<Short> a = new ArrayList<>();
		System.out.println(a.equals(LocalDateTime.now()));  //false
	}
	
	public static void main(String[] args) {
//		m();
//		m3();
		m3();
	}
}
