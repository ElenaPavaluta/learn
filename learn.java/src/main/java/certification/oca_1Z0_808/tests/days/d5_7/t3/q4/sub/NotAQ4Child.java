package days.d5_7.t3.q4.sub;

class NotAQ4Child {

	public static void main(String[] args) {
		Q4Child q = new Q4Child();
		
		q.childProtectedM();  //it's visible because I'm in the same package
//		q.protectedM()   //compiler error: not visible here 
	}
}
