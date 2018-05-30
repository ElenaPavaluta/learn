package oc.a.chapters._4_methods_and_encapsulation.overloadingMethods;

public class ReferenceTypes {

	void fly(String s){
		System.out.println("String");
	}
	
	void fly(Object o){
		System.out.println("object");
	}
	
	public static void main(String[] args) {
		ReferenceTypes rt = new ReferenceTypes();
		
		rt.fly("test");  //String
		rt.fly(56);  //object
	}
}
