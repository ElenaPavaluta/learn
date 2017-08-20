package days.d5_16.t2.inner;

class C extends A {

	/**
	 * Changing in the derived class the parameter type of a method with a
	 * covariant type is not a valid overriding it's valid overloading
	 */
	// @Override
	// ReturnTypeA m(ReturnTypeB param) {
	// return super.m(param);
	// }

	ReturnTypeA m(ReturnTypeB param) {
		return param;
	}
}
