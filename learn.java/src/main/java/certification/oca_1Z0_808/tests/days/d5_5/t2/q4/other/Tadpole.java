package days.d5_5.t2.q4.other;

import days.d5_5.t2.q4.animal.*;

public class Tadpole extends Frog{

	void m(){
		Frog f  = new Tadpole();
		super.ribbit();
	}
	
	void m2(){
		int a  = super.a;
//		int b = super.b  //compiler error
		
		super.ribbit();
//		super.jumb();  //compiler error
		
	}
	
	public static void main(String[] args) {
		Tadpole t = new Tadpole();
		t.ribbit();
		
		int aa = t.a;
		t.a = 0b01;
		
		
		
		/*
		 * compiler error: jump method in the superclass is defined as default, so not visible here
		 */
//		t.jump(); 
//		int bb = t.b;
		
		Frog f = new Tadpole();
		
		/*
		 * compiler error: both of these methods are not visible here
		 */
//		f.ribbit();
//		f.jump();
//		aa = f.a;
//		int bb = f.b;
	}
}
