package oc.a.chapters._4_methods_and_encapsulation;

public class ClassA {

	void m(int... a){
		System.out.println("ve");
	};
	
	public static void main(String[] args) {
		ClassA a = new ClassA();
		
		a.m(1,2,3);
	}
}
