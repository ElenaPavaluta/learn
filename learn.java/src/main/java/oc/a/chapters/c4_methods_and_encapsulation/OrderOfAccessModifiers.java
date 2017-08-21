package oc.a.chapters.c4_methods_and_encapsulation;

public abstract class OrderOfAccessModifiers {

	public static final void m() {
	};

	public final static void m2() {
	};

	final public void m3() {
	};

	final static public void m4() {
	};

	final public static void m5() {
	};

	static public final void m6() {
	};

	static final public void m7() {
	};

	abstract void m8();
	
	synchronized static public final void m9(){};
	
	public static final synchronized void m10(){};

	// void public m8(){}; compiler error

}
