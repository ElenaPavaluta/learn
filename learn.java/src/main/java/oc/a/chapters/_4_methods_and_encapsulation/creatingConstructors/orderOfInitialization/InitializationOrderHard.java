package oc.a.chapters._4_methods_and_encapsulation.creatingConstructors.orderOfInitialization;

class InitializationOrderHard {

	static {
		add(2);
	}

	static void add(int num) {
		System.out.print(num + " ");
	}

	public InitializationOrderHard() {
		add(5);
	}

	static {
		add(4);
	}

	{
		add(6);
	}

	static {
		new InitializationOrderHard();
	}

	{
		add(8);
	}

	public static void main(String[] args) {
	}
	
	//2 4 6 8 5
}
