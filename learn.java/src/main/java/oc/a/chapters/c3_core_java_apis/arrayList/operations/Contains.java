package oc.a.chapters.c3_core_java_apis.arrayList.operations;

import java.time.LocalDateTime;
import java.util.ArrayList;

class Contains {

	static  ArrayList<Short> arr = new ArrayList<>();
	
	static{
		arr.add((short)0);
		arr.add((short)1);
		arr.add((short)2);
		arr.add((short)3);
	}
	
	static void m(){
		System.out.println(arr.contains(3));  //false; because the element is autoboxed to an Integer
	}
	
	static void m2(){
		System.out.println(arr.contains((short)3));  //true
	}
	
	
	static void m3(){
		System.out.println(arr.contains(LocalDateTime.now()));  //false
	}
	
	
	static void m4(){
		System.out.println(arr.contains(null));  //false
	}
	
	public static void main(String[] args) {
		m();
		m2();
		m3();
		m4();
	}
}
