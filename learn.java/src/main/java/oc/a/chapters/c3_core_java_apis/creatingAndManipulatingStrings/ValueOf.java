package oc.a.chapters.c3_core_java_apis.creatingAndManipulatingStrings;

public class ValueOf {

	static char[] ca = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	static void m() {
		String s = String.valueOf(ca, 1, 2);
		System.out.println(s); // 12
		
		int offset = 1;
		int len = ca.length - offset;
		s = String.valueOf(ca, offset, len);
		System.out.println(s);
	}

	static void m2() {
		String s;
		s = String.valueOf(ca, 1, 15);  //StringIndexOutOfBoundsException:
		System.out.println(s);
		
		s = String.valueOf(ca, 11, 15);  //StringIndexOutOfBoundsException
		System.out.println(s);
	}

	public static void main(String[] args) {
		 m();
//		m2();
	}
}
