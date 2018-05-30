package oc.a.chapters._3_core_java_apis.creatingAndManipulatingStrings.immutability;

/**
 * Make all the fields private and final No set-ers, only get-ers Ensure
 * exclusive access to any mutable components Ensure that the class can't be
 * extended (final class or static factory interfaceMethods)
 */
public class Immutability {

	/**
	 * Once a String object is created, it is not allowed to change
	 */

	static void m(){
		String s = "1";
		String s2 = s.concat("2");
		s2.concat("3");
		System.out.println(s2);  //12
	}
	
	public static void main(String[] args) {
		m();
	}
}
