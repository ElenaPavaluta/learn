package oc.a.chapters._6_exceptions.recognizingCommonExceptionTypes.errors;

/**
 * Since the method calls itself, it will never end. Eventually, Java runs out
 * of room on the stack and throws the error. 
 * 
 * This is called infinite recursion. 
 * 
 * It is better than an infinite loop because at least Java will
 * catch it and throw the error. With an infi ite loop, Java just uses all your
 * CPU until you can kill it.
 *
 */
class StackOverflowError {

	static int i;

	static void doNotCodeThis(int nr) {
		System.out.println(i++);
		doNotCodeThis(nr);
	}

	public static void main(String[] args) {
		doNotCodeThis(007);
	}
}
