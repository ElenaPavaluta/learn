package oc.p.chapters._1_AdvancedClassDesign.usingInstanceof;

/**
 * The compilation check only applies when instanceof is called on a class. When checking
 * whether an object is an instanceof an interface, Java waits until runtime to do the
 * check. The reason is that a subclass could implement that interface and the compiler
 * wouldn’t know it.
 */
class Run
{
	static void m()
	{
		Animal a = new Hippo();

		System.out.println(a instanceof Animal);  //true
		System.out.println(a instanceof Hippo);  //true
		System.out.println(a instanceof Bird);  //false
		System.out.println(a instanceof QI);  //false
	}

	static void m2()
	{
		Hippo h = new Hippo();

		System.out.println(h instanceof Animal);  //true
		System.out.println(h instanceof Hippo);  //true

		/**
		 * A subclass of Hippo could never extend Bird (it would mean to extend 2 classes: imposible in java)
		 */
		//		System.out.println(h instanceof Bird);  //compiler error
		System.out.println(h instanceof QI);  //false
	}

	static void m3()
	{
		I i = new IA();

		System.out.println(i instanceof I);  //true
		System.out.println(i instanceof IA);  //true
		System.out.println(i instanceof IB);  //false
		System.out.println(i instanceof QI);  //false
	}

	static void m4()
	{
		IA ia = new IA();

		System.out.println(ia instanceof I);  //true
		System.out.println(ia instanceof IA);  //true
		//		System.out.println(ia instanceof IB);  //compiler error
		System.out.println(ia instanceof QI);  //false
	}

	static void m5(){
		QI qi = null;  //the variable needs to be initialzed before using it with the instanceof operator
		System.out.println(qi instanceof Object);  //false; null isn't an object
	}

	static void m6(){
		String s = "a";
//		System.out.println (s instanceof StringBuilder );  //compiler error
	}

	public static void main(String[] args)
	{
		//		m();
		//		m2();
		//		m3();
//		m4();
	}
}
