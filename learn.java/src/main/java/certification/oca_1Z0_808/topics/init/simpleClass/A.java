package topics.init.simpleClass;

public class A {

	private Aobj o = new Aobj("o");
	private Aobj o2, o3;
	{
		o2 = new Aobj("o2");
		o3 = new Aobj("o3");
	}

	private static Aobj os = new Aobj("static os");
	private static Aobj os2;
	private static Aobj os3;

	static {
		os2 = new Aobj("static os2");
		os3 = new Aobj("static os3");
	}
	
	public A(){
		System.out.println("A constructor");
	}
	
	public  A(String s) {
		System.out.println("A constructor: " + s);
	}
	
	public static void m(){
		System.out.println("in A");
	}
}
