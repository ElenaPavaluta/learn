package designPatterns.behavioral.visitor;

public class Necesity implements Visitable {

	private double price;

	private Necesity(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public double accept(Visitor visitor) {
		return visitor.visit(this);
	}

}
