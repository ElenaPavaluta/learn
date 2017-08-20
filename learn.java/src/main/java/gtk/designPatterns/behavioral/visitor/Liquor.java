package designPatterns.behavioral.visitor;

public class Liquor implements Visitable {

	private double price;

	private Liquor(double price) {
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
