package days.d5_16.t3;

class B extends A{

	static String tempB = "temp in B";
	
	static{
		System.out.println("static block in B");
	}
	
	static void b(){
		System.out.println("static method in B");
	}
	
	public static void main(String[] args) {
		System.out.println(tempA);
	}
}
