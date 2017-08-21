package oc.a.chapters.c4_methods_and_encapsulation.simpleLambdas.necesity;

public class CheckIfHopper implements CheckTrait{

	@Override
	public boolean test(Animal a) {
		return a.canHop();
	}

}
