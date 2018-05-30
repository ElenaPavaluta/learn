package oc.a.chapters._6_exceptions.usingATryStatement.catchingVariosTypesOfException;

class SeeAnimals {

	// the order in which the exception are thrown by a method does not matter
	// for the compiler
	void seeAnim() throws ExhibitClosed, ExhibitClosedForLunch, RuntimeException, Exception, AnimalsOutForWalk {
	}

	/**
	 * The correct order in which these exceptions can be catched
	 */
	void m() {
		try {
			seeAnim();
		} catch (ExhibitClosedForLunch e) { // subclass of ExhibitClosed
			e.printStackTrace();
		} catch (ExhibitClosed e) { // subclass of RuntimeException
			e.printStackTrace();
		} catch (RuntimeException e) { // subclass of Exception (unchecked
										// exceptions)
			e.printStackTrace();
		} catch (AnimalsOutForWalk e) { // subclass of Exception
			e.printStackTrace();
		} catch (Exception e) { // first implementation of Throwable
			e.printStackTrace();
		}
	}

	/*
	 * Even if 2 exceptions are not explicitly catched the compiler doesn't
	 * complain because we're catching superclass of those exceptions
	 */
	void m2() {
		try {
			seeAnim();
		} catch (ExhibitClosed e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void m3() {
		try {
			seeAnim();
		} catch (Exception e) {
			e.printStackTrace();
			// compiler error: unreachable code
			// } catch (ExhibitClosedForLunch e) {
			// e.printStackTrace();
			// } catch (ExhibitClosed e) {
			// e.printStackTrace();
			// } catch (RuntimeException e) {
			// e.printStackTrace();
			// } catch (AnimalsOutForWalk e) {
			// e.printStackTrace();
			// }
		}
	}

	void m4() {
		try {
			seeAnim();
		} catch (ExhibitClosedForLunch e) {
			e.printStackTrace();
		} catch (ExhibitClosed e) {
			e.printStackTrace();

		} catch (AnimalsOutForWalk e) { // This exception and RuntimeException
										// are sibilings
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
