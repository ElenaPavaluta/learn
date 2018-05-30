package oc.a.chapters._2_operators_and_statements.usingAdditionalBinaryOperators;

public class EqualityOperators {

	static void m(){
		int i = 5;
		double d = 5.00;
		
		System.out.println(i==d);  // true; numeric promotion
		
		Integer i2 = new Integer(27);
		Integer i3 = new Integer(27);
		
		System.out.println(i2 == i3); //false;
	}
	
	static void m2(){
		System.out.println(null == null); //true
	}
	
	public static void main(String[] args) {
//		m();
		m2();
	}
}
