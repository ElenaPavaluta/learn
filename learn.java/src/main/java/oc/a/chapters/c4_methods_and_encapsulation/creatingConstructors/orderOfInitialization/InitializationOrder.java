package oc.a.chapters.c4_methods_and_encapsulation.creatingConstructors.orderOfInitialization;

class InitializationOrder {

	private String name = "Torchie";
	{
		System.out.println(name);
	}
	
	private static int COUNT = 0;
	
	static{
		System.out.println(COUNT);
	}
	
	{
		COUNT++;
		System.out.println(COUNT);
	}
	
	public InitializationOrder() {
		System.out.println("Constructor");
	}
	
	public static void main(String[] args) {
		System.out.println("ready to construct");
		new InitializationOrder();
	}
	
	//0
	//ready to construct
	//Torchie
	//1
	//Constructor
}
