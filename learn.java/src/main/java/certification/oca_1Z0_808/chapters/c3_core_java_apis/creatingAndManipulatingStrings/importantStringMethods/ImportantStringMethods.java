package chapters.c3_core_java_apis.creatingAndManipulatingStrings.importantStringMethods;

/**
 * 
 * A string is a sequence of characters and Java counts from 0 when indexed
 *
 */
public class ImportantStringMethods {

	static String animals = "animals";

	static void length() {
		System.out.println(animals.length()); // 7
	}

	static void charAt() {
		System.out.println(animals.charAt(0)); // a
		System.out.println(animals.charAt(6)); // s
		System.out.println(animals.charAt(7)); // throws
												// StringIndexOutOfBoundsException
		System.out.println(animals.charAt(-1)); // throws
												// StringIndexOutOfBoundsException
	}
	
	static void equals(){
		System.out.println("animal".endsWith(animals));  //false
		System.out.println("a" + "nim" + "a" + "ls".equals(animals));  //animafalse (concatenation)
		System.out.println(("a" + "nim" + "a" + "ls").equals(animals));  //true
		System.out.println("a" + "nim" + "a" + "ls" == animals );  //true
		
	}

	static void equalsIgnoreCase(){
		System.out.println("ANImals".equalsIgnoreCase(animals));  //true
	}
	
	static void trim(){
		String s  = "  I will remove the any leading and trailing space         ";
		String ns = s.trim();
		System.out.println(ns);
	}

	public static void main(String[] args) {
//		length();
//		charAt();
//		equals();
//		equalsIgnoreCase();
		trim();
	}
}
