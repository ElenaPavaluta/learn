package chapters.c3_core_java_apis.creatingAndManipulatingStrings.importantStringMethods;

/**
 * 
 * String substring(int beginIndex)
 * 
 * String substring(int beginIndex, int endIndex)
 *
 */
public class Substring {

	static String s = "logitech";

	static void substring() {
		System.out.println(s.substring(3)); // itech
		System.out.println(s.substring(s.indexOf('e'))); // ech
		System.out.println(s.substring(-1)); // IndexOutOfBoundsExceotion
	}

	static void substring2() {
		System.out.println(s.subSequence(3, 4)); // i

		/*
		 * Returns the string starting from the requested index. If an end index
		 * is requested, it stops right before that index. Otherwise, it goes to
		 * the end of the string.
		 */
		System.out.println(s.substring(3, 8)); // itech
		System.out.println(s.substring(3, 19)); // StringIndexOutOfBoundException
		System.out.println(s.substring(3, 2)); // StringIndexOutoFBoundsException
	}

	public static void main(String[] args) {
		// substring();
		substring2();
	}
}
