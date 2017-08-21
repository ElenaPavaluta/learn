package days.d5_7.t3.q4.sub;

import days.d5_7.t3.q4.Q4;

class Q4Child extends Q4{


	void childProtectedM(){
		super.protectedM();
		this.protectedM();
		protectedM();
	}
	
	public static void main(String[] args) {
		Q4Child q = new Q4Child();
		
		q.protectedM(); //visible because the main method is defined in a subclass of Q4
	}
}
