package oc.a.chapters.c5_class_design.understantingPolymorfism.polymorfismAndMethodOverriding;

class ZooKeeper {

	static void feed(Animal a) {
		System.out.println("feed: " + a.getName());
	}

	public static void main(String[] args) {
		feed(new Animal());
		feed(new Gorilla());

		/*
		 * Override rules justified by polymorphism
		 *
		 * 1. the method in the sub class cannot be less accessible than the one
		 * in the super class
		 *
		 * 2. the m in the sub class cannot throw a checked exception newer or
		 * broader than the one thrown by the method in the super class
		 *
		 * 3. the return data type of the method in the sub class must be a
		 * covariant of the data types returned by the method in the super class
		 */
	}
}
