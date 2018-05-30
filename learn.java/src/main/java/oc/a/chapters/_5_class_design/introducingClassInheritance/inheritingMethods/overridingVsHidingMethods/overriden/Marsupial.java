package oc.a.chapters._5_class_design.introducingClassInheritance.inheritingMethods.overridingVsHidingMethods.overriden;

public class Marsupial {

	public boolean isBiped(){
		return false;
	}
	
	public void getMarsupialDesc(){
		System.out.println("marsupial: " + isBiped());
	}
}
