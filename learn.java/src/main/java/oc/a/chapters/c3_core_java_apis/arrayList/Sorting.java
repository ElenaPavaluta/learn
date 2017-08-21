package oc.a.chapters.c3_core_java_apis.arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sorting {

	static void m(){
		Integer[] ai = new Integer[]{13, 14, 1, 2, 0};
		Arrays.sort(ai);

		List<Integer> lst = Arrays.asList(ai);
		System.out.println(lst);
	}
	
	static void m2(){
		int[] ai = new int[]{13, 14, 1, 2, 0};

//		List<Integer> lst = Arrays.asList(ai);  //compiler error
		
		List<int[]> lst2 = Arrays.asList(ai);
	}
	
	static void m3(){
		List<Integer> lst = new ArrayList<Integer>();
		lst.add(13);
		lst.add(14);
		lst.add(1);
		lst.add(2);
		lst.add(0);
		
		Collections.sort(lst);
		
//		int[] ai = lst.toArray(new int[0]);  //compiler error: beware
		
		Integer[] ai2 = lst.toArray(new Integer[0]);
		
		for(int i: ai2){
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		m();
		m3();
	}
}
