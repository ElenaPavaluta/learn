package oc.a.chapters.c5_class_design.implementingInterfaces.defaultInterfaceMethods;

public interface HasFins {

	default int getNbOfFins(){  //assumed to be public
		return 4;
	}
	
	default double getLongestFinLength(){  //assumedto be public
		return 20;
	}
	
	public default boolean doFinsHaveScales(){
		return true;
	}
}
