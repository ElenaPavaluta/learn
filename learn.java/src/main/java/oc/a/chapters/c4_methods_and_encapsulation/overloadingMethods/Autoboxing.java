package oc.a.chapters.c4_methods_and_encapsulation.overloadingMethods;

/**
 * Java will convert a primitive int to an object Integer to add it to an
 * ArrayList through the wonders of autoboxing. This works for code you write
 * too.
 *
 */
public class Autoboxing {

	static class A {
		static void fly(Integer num) {
			System.out.println("Integer");
		}
	}

	static class B {
		static void fly(int num) {
			System.out.println("int");
		}

		static void fly(Integer num) {
			System.out.println("Integer");
		}

	}

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		
		int i = 007;
		Integer wrapper = Integer.valueOf(i);
		
		a.fly(i);  //Integer: int "i" it will be wrapped to Integer
		b.fly(i);  //int; the most specific function will be called
		
		a.fly(wrapper);  //Integer
		b.fly(wrapper);  //Integer
		
	}
}
