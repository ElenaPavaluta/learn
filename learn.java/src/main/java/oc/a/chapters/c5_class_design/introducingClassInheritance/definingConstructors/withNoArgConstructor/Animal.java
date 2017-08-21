package chapters.c5_class_design.introducingClassInheritance.definingConstructors.withNoArgConstructor;

public class Animal {

	private int age;

	public Animal() {
		super();
		System.out.println("An animal is created");
//		super();  //compiler error: either super() or this() must be the first statement in a constructor
	}

	public Animal(int age) {
		this();
		this.age =  age;
	}
}
