package oc.a.topics.init.staticInit;

public class T2 {

	static void m() {
		A.a();
		// static block in A
		// static method in A
	}
	
	static void m2(){
		B.b();
		//static block in A
		//static block in B
		//static method in B
	}
	
	static void m3(){
		B.a();
		//static block in A
		//static method in A
	}
	
	
	static void m4(){
		System.out.println(B.tempA);
		//static block in A
		//temp in A
	}
	
	static void m5(){
		System.out.println(A.tempA);
		//static block in A
		//temp in A
	}
	
	static void m6(){
		System.out.println(B.tempB);
		//static block in A
		//static block in B
		//temp in B
	}

	public static void main(String[] args) {
//		m();
		
//		m2();
		
//		m3();
		
//		m4();
		
//		m5();
		
		m6();
		
		
	}
}
