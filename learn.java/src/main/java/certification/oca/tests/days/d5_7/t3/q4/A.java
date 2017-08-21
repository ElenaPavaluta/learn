package days.d5_7.t3.q4;

class A {

	public static void main(String[] args) {
		Q4 q = new Q4();
		
		/*
		 * Visible because I'm in the same package
		 */
		q.go();
		q.protectedM();
	}
}
