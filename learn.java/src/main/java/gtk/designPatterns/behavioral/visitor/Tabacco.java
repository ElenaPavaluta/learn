package designPatterns.behavioral.visitor;

public class Tabacco implements Visitable{

	@Override
	public double accept(Visitor visitor) {
		return visitor.visit(this);
	}

}
