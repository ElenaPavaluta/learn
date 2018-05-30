package oc.a.chapters._6_exceptions.recognizingCommonExceptionTypes.runtimeExceptions;

public class IllegalArgumentExceptions {

	static int a = 007;
	
	void setA(int a){
		if(a<=7){
			throw new IllegalArgumentException();
		}
	}
	
	void set(int i){
		System.out.println( i);
	}
	
	
	public static void main(String[] args) {
//		new IllegalArgumentExceptions().setA(5);
		
//		new IllegalArgumentExceptions().set(Integer.MAX_VALUE+5);
		
		System.out.println(Integer.parseInt("a"));
	}
}
