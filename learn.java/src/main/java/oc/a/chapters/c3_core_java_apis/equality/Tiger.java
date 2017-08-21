package oc.a.chapters.c3_core_java_apis.equality;

public class Tiger {

	String name;
	
	public static void main(String[] args) {
		Tiger t = new Tiger();
		Tiger t2 = new Tiger();
		Tiger t3 = t;
		
		System.out.println(t == t);  //true
		System.out.println(t == t2);  //false
		System.out.println(t.equals(t2));  //false
	}
}
