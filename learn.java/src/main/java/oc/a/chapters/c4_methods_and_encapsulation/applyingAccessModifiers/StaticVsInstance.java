package oc.a.chapters.c4_methods_and_encapsulation.applyingAccessModifiers;

public class StaticVsInstance {

	public static int count;
	
	public static void add(){
		count++;
	}
	
	public void add2(){
		count++;
	}
	
	public static void announce(){
		add();
//		add2();  //it's not a static method
	}
	
	public int total;
	
//	public static int average = total/count;  //total it's not a static variable
		
}

class Counter{
	
	private static int counter;  // it's initialized to the data type defaulT value

	private Counter() {
		counter++;
	}
	
	public static void main(String[] args) {
		new Counter();
		new Counter();
		new Counter();
		
		System.out.println(Counter.counter);  //3
	}
	
}
