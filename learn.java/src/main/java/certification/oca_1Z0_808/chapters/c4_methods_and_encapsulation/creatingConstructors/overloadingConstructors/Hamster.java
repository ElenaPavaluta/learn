package chapters.c4_methods_and_encapsulation.creatingConstructors.overloadingConstructors;

public class Hamster {

	private String color;
	private int weight;

	// public private protected
	Hamster() {
	}

	Hamster(int weiht) {
		this(weiht, "brown");
	}

	Hamster(int wight, String color) {
		this.weight = wight;
		this.color = color;
	}

	Hamster(int weight, int r, int g, int b) throws Exception {

	}
}
