package oc.a.chapters.c3_core_java_apis.stringBuilderClass;


public class MutabilityAndChaining {

	static void m(){
		StringBuilder sb = new StringBuilder("start");
		sb.append("+middle"); 
		
		StringBuilder same = sb.append("+end");
		
		System.out.println(sb == same); //
	}
	
	static void m2(){
		StringBuilder a = new StringBuilder("abc"); //a = "abc"
		StringBuilder b = a.append("de");  // a = abcde, b =a;
		b = b.append("f").append("g");  //
		System.out.println( a == b);  //true
		System.out.println("a: " + a);
		System.out.println("b: " + b);
	}
	
	public static void main(String[] args) {
//		m();
		m2();
	}
	
}
