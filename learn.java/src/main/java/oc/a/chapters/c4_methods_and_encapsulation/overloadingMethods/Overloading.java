package oc.a.chapters.c4_methods_and_encapsulation.overloadingMethods;

/**
 * Order Java uses to choose the right overloaded method
 * 
 * 1. Exact match by type
 *
 * 2. Larger primitive type
 * 
 * 3. Autoboxed type
 * 
 * 4. Varargs
 * 
 */
public class Overloading {

	static class A {
		void fly(long l) {
			System.out.println("long");
		}

		void fly(Integer i) {
			System.out.println("Integer");
		}
	}

	class Glider {
		void glide(String s) {
			System.out.println(1);
		}

		void glide(String... ss) {
			System.out.println(2);
		}

		void glide(Object o) {
			System.out.println(3);
		}

		void glide(String s, String t) {
			System.out.println(4);
		}
	}

	class TooManyConversions {
		void play(Long l) {
			System.out.println("Long");
		}

		void play(Long... longs) {
			System.out.println("Long...");
		}
	}

	public static void main(String[] args) {
		A a = new A();
		int i = 0b011;
		a.fly(i); // long

		Glider g = new Overloading().new Glider();
		g.glide("a"); // 1
		g.glide("a", "b"); // 4
		g.glide("a", "b", "c"); // 2

		TooManyConversions c = new Overloading().new TooManyConversions();
		
		/*
		 * Java is happy to convert the int 4 to a long 4 or an Integer 4. It
		 * cannot handle converting in two steps to a long and then to a Long
		 */
		// c.play(4); //compiler error
		c.play(4l);
	}
}
