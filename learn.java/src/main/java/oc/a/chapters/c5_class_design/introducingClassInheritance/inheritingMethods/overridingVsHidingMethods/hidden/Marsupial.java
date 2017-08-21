package oc.a.chapters.c5_class_design.introducingClassInheritance.inheritingMethods.overridingVsHidingMethods.hidden;

public class Marsupial {

	public static boolean isBiped(){
		return false;
	}
	
	public void getMarsupialDesc(){
		System.out.println("marsupial: " + isBiped());
	}
}
