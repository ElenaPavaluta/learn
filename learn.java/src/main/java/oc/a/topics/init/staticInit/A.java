package oc.a.topics.init.staticInit;

class A {

	static String tempA = "temp in A";
	
	static{
		System.out.println("static block in A");
	}
	
	static void a(){
		System.out.println("static method in A");
	}
}
