package oc.a.chapters.c3_core_java_apis.arrayList.autoboxing;

import java.util.ArrayList;
import java.util.List;

public class Autoboxing {

	static void m() {
		List<Double> weights = new ArrayList<Double>();

		weights.add(50.5); // autoboxing
		weights.add(new Double(60));
		weights.remove(50.5); // autoboxing. Here we're removing the element
								// 50.5;
		double first = weights.get(0); // unboxing

		System.out.println(weights); // the array list has overridden the
										// toString()

		weights.remove(0); // here the element on the first position is removed
		
		System.out.println(weights);
	}

	static void m2(){
		List<Integer> lst = new ArrayList<Integer>();
		
		lst.add(1);  //autoboxing 
		lst.add(2);  //autoboxing
		
		lst.remove(1);  //it will remove the element with the index 1
		
		lst.remove(Integer.valueOf(1));  //now it will actually remove the element 1
		
		System.out.println(lst);
	}
	
	static void m3(){
		List<Integer> heights = new ArrayList<Integer>();
		heights.add(null);  //it's permitted
		
		Integer wrapper = heights.get(0);  //wrapper = null
//		int i = heights.get(0);  //NullPoiterException: we're trying to unbox a null
	}
	
	public static void main(String[] args) {
		m();
		m2();
		m3();
	}
}
