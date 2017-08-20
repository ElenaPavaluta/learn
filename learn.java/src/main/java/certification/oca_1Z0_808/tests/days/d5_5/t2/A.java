package days.d5_5.t2;

class A {

	static void m() {
		StringBuilder s1 = new StringBuilder("meow");
		StringBuilder s2 = new StringBuilder("meow");

		if (s1 == s2)
			System.out.println("one");
		if (s1.equals(s2))
			System.out.println("two");

		/*
		 * Compiler error: comparing object of different data type
		 */
		// if(s1 == "meow") System.out.println("three");
		if (s1.equals("meow"))
			System.out.println("three"); // ok, because the equals method
											// expects an object. It's not going
											// to throw an ClassCastException
		if(s1.toString() == "meow") System.out.println("four");
	}
	
	public static void main(String[] args) {
		m();
	}
}
