package chapters.c3_core_java_apis.arrayList.recap.operations;

import java.util.ArrayList;
import java.util.List;

class Ops {

	static final List<Integer> lst = new ArrayList<>();
	
	static void m(){
		lst.add(1, 1);  //throws IndexOutOfBoundsException
	}
	
	static void m2(){
		lst.add(0);
		lst.add(0,11);
		System.out.println(lst);
		
		lst.set(0, 111);
		System.out.println(lst);
		
		lst.add(2, 2);
		System.out.println(lst);
	}
	
	static void m3(){
		lst.clear();
		lst.add(0, 5);
		lst.add(1, 10);
		lst.add(2, 20);
		lst.add(lst.size(), lst.size()*10);
		lst.add(lst.size(), lst.size()*10);
		lst.add(lst.size(), lst.size()*10);
		lst.add(new Integer(lst.size()), new Integer(lst.size()*10));
		System.out.println(lst);
		
		lst.remove(5);
		System.out.println(lst);
		lst.remove(new Integer(5));
		System.out.println(lst);
		
		lst.clear();
		System.out.println(lst);
	}
	
	static void m4(){
		lst.add(1);
		lst.add(2);
		
		System.out.println(lst.contains(2));  //true
		
		List<Integer> lst2 = new ArrayList<>();
		lst2.add(2);
		lst2.add(1);
		
		System.out.println(lst.equals(lst2));  //false
		
		lst2.set(0, 1);
		lst2.set(1, 2);
		
		System.out.println(lst2.equals(lst));  //true
	}
	
	public static void main(String[] args) {
//		m();
//		m2();
//		m3();
		m4();
	}
}
