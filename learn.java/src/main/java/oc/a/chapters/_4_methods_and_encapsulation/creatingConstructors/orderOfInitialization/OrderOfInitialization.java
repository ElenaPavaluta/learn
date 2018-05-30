package oc.a.chapters._4_methods_and_encapsulation.creatingConstructors.orderOfInitialization;

/**
 * 1. super()
 *
 * 2. static variable declarations and static initializers in the order they
 * appear in the file.
 *
 *
 * 3. instance variable declarations and instance initializers in the order they
 * appear in the file.
 * 
 * 4. the constructor
 */
public class OrderOfInitialization {

	private String name = "Torchie";

	{
		System.out.println(name);
	}

	private static int COUNT = 0;

	static {
		System.out.println(COUNT);
	}

	static {
		COUNT += 10;
		System.out.println(COUNT);
	}

	public OrderOfInitialization() {
		System.out.println("Constructor");
	}

	public static void main(String[] args) {
		new OrderOfInitialization();

		// 0
		// 10
		// Torchie
		// Construtor
	}
}
