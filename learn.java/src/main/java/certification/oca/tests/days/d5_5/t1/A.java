package days.d5_5.t1;

class A {

	private int i = 6;
	private int j = i;

	void A(){
		i = 5;
	}
	
	static void m(){
		/*
		 * Compiler error: can't access non static variables in static methods
		 */
//		int s = i+j;
		
		A a = new A();
		int s = a.i + a.j;
		System.out.println(s);  //12
	}
	
	
	public static void main(String[] args) {
		A a = new A();
		System.out.println(a.i + a.j);  //12
		
		m();
	}
}
