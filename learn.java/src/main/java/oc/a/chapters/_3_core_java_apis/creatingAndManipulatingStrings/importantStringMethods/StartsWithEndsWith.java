package oc.a.chapters._3_core_java_apis.creatingAndManipulatingStrings.importantStringMethods;

/**
 * boolean startsWith(String prefix)
 *
 * boolean startsWith(String prefix, int toffset)
 * 
 * boolean endsWith(String suffix)
 */
public class StartsWithEndsWith {

	private static String s = "logitech";
	private static String ss = "logitech logitech";

	static void startsWith() {
		System.out.println(s.startsWith("lo")); // true
		System.out.println(s.startsWith("m")); // false
	}

	static void startsWith2() {
		System.out.println(ss.startsWith("lo", 9)); // true
		System.out.println(ss.startsWith("lo", 8)); // false
		
//		System.out.println(ss.startsWith('l'));  //compilation error
	}

	static void endsWith() {
		System.out.println(s.endsWith(s)); // true
		System.out.println(s.endsWith("c"));  //false
		
//		System.out.println(ss.endsWith('c'));  //compilation error
	}

	public static void main(String[] args) {
		// startsWith();
		// startsWith2();
		endsWith();
	}
}
