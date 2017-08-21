package oc.a.chapters.c5_class_design.implementingInterfaces.defaultInterfaceMethods;

/**
 * 
 * Because all the methods are default, the compiler doesn't complain if we
 * don't override any method
 *
 */
public class HasFinsImpl implements HasFins {

	@Override
	public int getNbOfFins() {
		return HasFins.super.getNbOfFins();
	}

	@Override
	public double getLongestFinLength() {
		return HasFins.super.getLongestFinLength();
	}



}
