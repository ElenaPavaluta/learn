package gtk.designPatterns.behavioral.visitor;

/**
 * Allows the Visitor to pass the object so
 * the right operations occur on the right dbType of object. accept() is passed
 * the same visitor object but then the method visit() is called using the
 * visitor object. The right version of visit() is called because of method
 * overloading
 */

public interface Visitable {

	public double accept(Visitor visitor);
}
