package oc.a.chapters.c5_class_design.implementingInterfaces.defaultInterfaceMethods;

public interface SharkFamily extends HasFins {

	@Override
	default int getNbOfFins() { // overrides the behavior
		return 8;
	}

	@Override
	double getLongestFinLength(); // redeclares this method

	@Override
	default boolean doFinsHaveScales() { // uses this as it is (overriden here
											// only for explanatory purposes)
		return HasFins.super.doFinsHaveScales();
	}

}
