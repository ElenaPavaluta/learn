package oc.a.chapters._5_class_design.introducingClassInheritance.inheritingVariables;

public class Mouse extends Rodent{

	int tailLenght = 81;
	
	void getMouseTail(){
		System.out.println("mouse tail: " + tailLenght);
	}
	
}
