package oc.a.chapters._3_core_java_apis.creatingAndManipulatingStrings;

/**
 * If both operands are numeric, + means numeric addition
 * 
 * If either operands is a String, + means concatenation
 * 
 * The expression is evaluated left to right
 *
 */
public class Concatenation {

	static void m() {
		System.out.println(1 + 2); // 3
		System.out.println("a" + "b"); // ab
		System.out.println("a" + "b" + 3); // abc
		System.out.println(1 + 2 + "c"); // 3c
		System.out.println(1 + 2 + 'c'); // 102
	}

	static void m2() {
		int three = 3;
		String four = "4";
		System.out.println(1 + 2 + three + four); // 64
	}

	static void m3() {
		String s = "1";
		s += "2";
		s += '3';
		s += 4;
		System.out.println(s); // 1234
	}

	public static void main(String[] args) {
		// m();
		// m3();
		m3();
	}
}
