package oc.a.chapters._1_building_blocks.class_structure.classes_vs_files;

/*
 * Note:
 * 
 * only one class can be public;
 * the accepted access modifiers are public(used only once) and defaulT(package)
 * 
 * When it is compiled this source code will create a .class file for each of the declared classes
 * 
 */
public class Animal {

	public static void main(String[] args) {
		System.out.println("Hello world from Animal class");
	}
}

/*
 * public class Animal2 would not compile in a file named Animal.java.
 */
/* public */class Animal2 {

}

abstract class Animal3 {
}

final class Animal4 {
}

interface Animal5{
	
}

/*
 * Not allowed It can be either abstract or final, but not both
 */
// abstract final class Animal5{
//
// }

/*
 * Not allowed
 */
// private class Animal3{
//
// }

/*
 * Not allowed
 */
// protected class Animal4{
//
// }
