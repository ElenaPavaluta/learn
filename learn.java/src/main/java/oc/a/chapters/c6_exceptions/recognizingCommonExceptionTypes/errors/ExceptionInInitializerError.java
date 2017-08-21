package chapters.c6_exceptions.recognizingCommonExceptionTypes.errors;

/**
 * The ExceptionInInitializerError is an error because Java failed to load the
 * whole class. This failure prevents Java from continuing.
 *
 */
class ExceptionInInitializerError {

	static {
		int[] arr = new int[3];
		System.out.println(arr[-1]);
	}

	public static void main(String[] args) {

	}
}
