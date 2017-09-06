package oc.a.chapters.c6_exceptions.callingMethodsThatThrowsExceptions.subclasses;

class Child extends Base {

	/*
	 * Compiler error: the override method can not throw a broader or a newer
	 * exception tahn the one in the base class
	 */
	// @Override
	// void m() throws CheckedException{
	// super.m();
	// }

	@Override
	void m2() throws CE2 {
		try {
			super.m2();
		} catch (CE e) {
			throw new CE2();
		}
	}

	/*
	 * Although the m4 in base class doesn't throw an exception the override
	 * method can throw as many unchecked exceptions (RuntimeException and it's
	 * derived classes) as it wants, due to the fact that this are redundant
	 * (this exception do not need neither to be declared or handled).
	 */
	@Override
	void m3() throws RE, RuntimeException {
		super.m3();
	}

}
