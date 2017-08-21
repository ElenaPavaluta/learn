package chapters.c4_methods_and_encapsulation.overloadingMethods;

public class Primitives {

	static void fly(int i) {
		System.out.println("int");
	}

	static void fly(long l) {
		System.out.println("long");
	}
	
	public static void main(String[] args) {
		fly(123);
		fly(007l);
	}
}
