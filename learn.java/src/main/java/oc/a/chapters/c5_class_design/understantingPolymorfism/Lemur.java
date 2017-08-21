package oc.a.chapters.c5_class_design.understantingPolymorfism;

public class Lemur extends Primate implements HasTail {

	@Override
	public boolean isTailStriped() {
		return false;
	}

	int age = 10;

	public static void main(String[] args) {
		Lemur lemur = new Lemur();
		System.out.println(lemur.age);

		HasTail hasTail = lemur;
		System.out.println(hasTail.isTailStriped());

		Primate primate = lemur;
		System.out.println(primate.hasHair());

		// System.out.println(hasTail.age); //compiler error

		// System.out.println(primate.isTailStriped());// compiler error
	}
}
