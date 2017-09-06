package oc.a.chapters.c6_exceptions.callingMethodsThatThrowsExceptions;

class Bunny {

	static void eatCarrots() throws NoMoreCarrotException {
	}

	static void eatCarrotsNoException() {
	}
	
	static void m() {
		try {
			eatCarrots();
		} catch (NoMoreCarrotException e) {  //handle the exception
			System.out.println("sad rabbit");
		}
	}


	
	static void m2(){
	/*
	 * Compiler error: unreachable code
	 */
//		try {
//			eatCarrotsNoException();
//		} catch (NoMoreCarrotException e) {
//			System.out.println("sad bunny in m3");
//		}
	}
	
	/*
	 * Although the eatCarrotsNoException doesn't throws an exception nobody stop us throw a new Exception 
	 */
	static void m3() throws NoMoreCarrotException, Exception{
		eatCarrotsNoException();
	}
	

	public static void main(String[] args) throws NoMoreCarrotException {  //declare the exception

		/*
		 * because this method throws a checked exception, it needs either to
		 * handle it or declare it
		 * 
		 * Note that also the main method can throw an exception
		 */
		eatCarrots();

	}
}
