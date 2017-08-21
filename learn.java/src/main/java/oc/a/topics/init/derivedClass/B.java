package oc.a.topics.init.derivedClass;

import oc.a.topics.init.simpleClass.A;

public class B extends A{

	private Bobj b;
	private static Bobj bs;

	{
		b = new Bobj("b");
	}
	static{
		bs = new Bobj("static bs");
	}

	public B(String s) {
		super(s);
		System.out.println("B constructor: " + s);
	}
	
	public static void m(){
		System.out.println("in B");
	}
	
	public static void main(String[] args) {
		A a = new A("a");
//		Delimitators.delimitatorEqual();
//		B b = new B("b");
	}

	
}
