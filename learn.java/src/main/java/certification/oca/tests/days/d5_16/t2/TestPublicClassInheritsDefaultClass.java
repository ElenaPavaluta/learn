package days.d5_16.t2;

import days.d5_16.t2.inner.PublicClassInheritsDefaultClass;

public class TestPublicClassInheritsDefaultClass {

	public static void main(String[] args) {
		PublicClassInheritsDefaultClass ins = new PublicClassInheritsDefaultClass();
		
		/*
		 * Because the m method has a package visibility it's not accessible here 
		 */
		//ins.m(null);
	}
}
