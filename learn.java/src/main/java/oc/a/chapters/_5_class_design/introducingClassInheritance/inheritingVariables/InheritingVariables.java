package oc.a.chapters._5_class_design.introducingClassInheritance.inheritingVariables;

import utils.delimitators.Delimitators;

/**
 * Hide a variable: define a var with the same dishName both for the parent and
 * child class
 * 
 * 
 * As when hiding a static method, if you�re referencing the variable from
 * within the parent class, the variable defined in the parent class is used.
 * Alternatively, if you�re referencing the variable from within a child class,
 * the variable defined in the child class is used.
 *
 */
public class InheritingVariables {

	
	static void m(){
		Rodent r = new Rodent();
		Rodent r2 = new Mouse();
		
		System.out.println(r.tailLenght);  //8
		System.out.println(r2.tailLenght);  //8
		
		Delimitators.equal();
	}
	
	static void m2(){
		Rodent r = new Mouse();
		Mouse m = new Mouse();
		
		System.out.println(r.tailLenght); //8
		System.out.println(m.tailLenght);  //81
		
		Delimitators.equal();
	}
	
	
	static void m3(){
		Mouse m = new Mouse();
		
		System.out.println(m.tailLenght);  //81
		m.getRodentTail();    //rodent tail: 8
		m.getMouseTail();  	//mouse tail: 81
	}
	
	public static void main(String[] args) {
		m();
		m2(); 
		m3();
	}
	
}
