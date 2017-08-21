package oc.a.chapters.c5_class_design.introducingClassInheritance.inheritingMethods.overridingVsHidingMethods.overriden;

public class Kangaroo extends Marsupial{

	public  boolean isBiped(){
		return true;
	}
	
	public void getKangarooDesc(){
		System.out.println("Kangaroo: " + isBiped());
	}
}
