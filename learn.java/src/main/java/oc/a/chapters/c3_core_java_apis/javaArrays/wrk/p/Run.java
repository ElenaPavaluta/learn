package oc.a.chapters.c3_core_java_apis.javaArrays.wrk.p;

import java.time.LocalDateTime;
import java.util.Arrays;

abstract class Run {

	static Sub[] arr = new Sub[3];

	final static void m() {
		Super[] aS = arr; // perfect legal, because Sub extends Super

		Sub[] as = (Sub[]) aS;

		// as[0] = new Sub2(); //compiler error: Sub and Sub2 are sibiling

		aS[0] = new Sub2(); // perfect legal (for the compiler), because Sub2
							// extends Super, but the array elements type is
							// actually Sub not Super, nor Sub2 which only means
							// a runtime exception (ArrayStoreException)

	}

	// protected abstract static void m2(); //compiler error

	// abstract static void m3(); //compiler error

	// abstract final void m4(); //compiler error

	// private abstract void m5(); //compiler error

	protected abstract void m6();

	abstract void m7();
	
	static final void m8(){
		Object[] a = new Object[]{new Super(), new Sub2(), new Sub(), LocalDateTime.now()};
		System.out.println(Arrays.toString(a));
	}

	public final static void main(final String[] args) {
		System.out.println("I can run in an abstract class");
		
//		m();
		m8();
	}
}
