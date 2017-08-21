package oc.a.chapters.c6_exceptions.usingATryStatement.throwingASecondException.onlyTheLastExceptionGetsThrown;

import utils.delimitators.Delimitators;

/**
 *
 * Only the last exception gets thrown.
 * 
 * if there's a return statement in the finally block and this doesn't throw an
 * exception then this is the method existing return
 *
 */
class OnlyTheLastExceptionGetsThrown {

	void m() throws FinallyException {
		try {
			throw new TryException();
		} catch (TryException e) {
			throw new CatchException();
		} finally {
			throw new FinallyException(); // checked exception: the method needs
											// either to declare it or to
											// handle it
		}
	}

	String m2() throws FinallyException {
		try {
			return "after try in m2";
			/*
			 * compiler error: unreachable code
			 */
			// throw new TryException();
			// } catch (TryException e) {
			// throw new CatchException();
		} finally {
			throw new FinallyException(); // checked exception
		}

		// return "after finally"; //unreachable code
	}

	String m3() throws FinallyException {
		try {
			return "after try in m3";

		} finally {
			if (1 > 2) {
				throw new FinallyException();
			}
			return "after finally in m3";
		}

	}

	void m4() {
		try {
			throw new TryException();
		} catch (TryException e) {
			throw new CatchException();
		} finally {
			throw new RuntimeException(); // unchecked exception
		}
	}

	public static void main(String[] args) {
		OnlyTheLastExceptionGetsThrown o = new OnlyTheLastExceptionGetsThrown();

		try {
			o.m();
		} catch (FinallyException e) {
			System.out.println("catched FinallyException");
		}

		try {
			String s = o.m2();
			System.out.println(s); // it's not going to reach this point
		} catch (FinallyException e) {
			System.out.println("catched FinallyException in m2");
		}

		try {
			String s = o.m3();
			System.out.println(s); // after finally in m3
		} catch (FinallyException e) {
			System.out.println("catched FinallyException in m3");
		}

		Delimitators.equal();

		o.m4(); // throws RuntimeException since it's not handled. Because it's
				// an unchecked exception it doesn't need to be handled
	}
}
