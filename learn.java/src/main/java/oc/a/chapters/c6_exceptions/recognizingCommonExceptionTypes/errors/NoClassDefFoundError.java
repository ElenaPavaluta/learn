package oc.a.chapters.c6_exceptions.recognizingCommonExceptionTypes.errors;

/**
 * NoClassDefFoundError occurs when Java can�t find the class at runtime
 *
 */
class NoClassDefFoundError {

	static void jdbc(){

		try {
			Class.forName("BlaBlaClass");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		jdbc();
	}
}
