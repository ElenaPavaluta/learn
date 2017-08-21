package oc.a.chapters.c3_core_java_apis.arrayList.operations;

import java.util.ArrayList;
import java.util.List;

class Constructor {

	static void m(){
		ArrayList<Short> al = new ArrayList<>();
		ArrayList<Short> al2 = new ArrayList<>(al);
	}
	
	static void m2(){
		Integer[] i = new Integer[5];
//		ArrayList<Integer> a = new ArrayList<>(i);  //compilation error
	}
	
	
	static void m3(){
		Integer[] a = new Integer[]{1,2,3,};
	}
	
	static void m4(){
		List<Boolean> l = new ArrayList<>();
		List<Boolean> l2 = new ArrayList<>(l);
	}
}
