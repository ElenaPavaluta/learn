package oc.p.chapters.c2_PatternsAndPrinciples.implementingPolymorphism.castingObjectReference.pex;

/**
 * The object exists on the heap memory and it is accessible only through a reference.
 * The reference type to an object "decides" what fields and methods of the object are accessible throughout that reference
 */
class Run
{
	static void m()
	{
		A a = new A();
		B b = (B) a;  //runtime error ClassCastException
	}

	static void m2()
	{
		A a = new C();
		B b = (B) a;
		C c = (C) b;
		c = (C) a;

		B2 b2 = (B2) a;  //runtime exception: Class cast exception
	}

	static void m3()
	{
		B b = new B();
		//		B2 b2 = (B2)b;  //compiler error: A subclass of B2 could never extend B (single inheritance in java)
	}

	static void m4()
	{
		I i = new C();
		B b = (B) i;
		C c = (C) i;
		A a = (A) i;  //ok, because a subclass of A implements the I interface; And basically by casting you're actually changing
		// the reference to an object, not the object itself.
	}

	static void m5()
	{
		I i = new C();
		I2 i2 = (I2) i;  //ClassCastException: a subclass of I2 can implement I
	}

	public static void main(String[] args)
	{
		//		m();
		//		m2();
		//		m4();
		m5();
	}
}
