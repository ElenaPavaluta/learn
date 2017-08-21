package gtk.designPatterns.behavioral.visitor;

public interface Visitor {

	double visit(Liquor liquor);

	double visit(Necesity necesity);

	double visit(Tabacco tabacco);

}
