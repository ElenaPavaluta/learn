package chapters.c5_class_design.introducingClassInheritance.callingInheritedClassMembers;

public class B extends A{

	protected int b = 7;
	
	protected void mb(){
		System.out.println(this.a);
		System.out.println(super.a); //same thing
	}
}
