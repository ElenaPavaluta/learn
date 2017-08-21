package chapters.c3_usingOperatorsAndDecisionConstructs.q27;

class Q {

	static void m(){
		String s = "some sord of String";
		String s2 = null;
		
		System.out.println(s.equals(s2));  //false
		
		System.out.println(s2 instanceof String);  //false
	}
	
	public static void main(String[] args) {
		m(); 
	}
}
