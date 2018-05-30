package oc.a.chapters._5_class_design.introducingClassInheritance.understandingCompilerEnhancements.callingConstructors;

public class Chimpanzee extends Ape{

	public Chimpanzee(){
		System.out.println("Chimpanzee");
	}
	
	public static void main(String[] args) {
		new Chimpanzee(); // Primate \n Ape \n Chimpanzee
	}
}
