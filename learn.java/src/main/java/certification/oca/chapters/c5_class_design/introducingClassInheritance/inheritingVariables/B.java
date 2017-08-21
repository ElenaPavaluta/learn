package chapters.c5_class_design.introducingClassInheritance.inheritingVariables;

public class B extends A{

	public int lenght = 5;
	
	public static void main(String[] args) {
		A a = new B();
		B b  = new B();
		
		System.out.println(a.lenght);  //2
		System.out.println(b.lenght);  //5
	}
}
