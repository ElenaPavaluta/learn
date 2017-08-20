package chapters.c5_class_design.introducingClassInheritance.inheritingMethods.overridingVsHidingMethods.hidden;

public class Kangaroo extends Marsupial{

	public static boolean isBiped(){
		return true;
	}
	
	public void getKangarooDesc(){
		System.out.println("Kangaroo: " + isBiped());
	}
}
