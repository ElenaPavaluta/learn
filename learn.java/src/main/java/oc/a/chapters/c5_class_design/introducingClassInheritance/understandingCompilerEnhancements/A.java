package chapters.c5_class_design.introducingClassInheritance.understandingCompilerEnhancements;

public class A {

	public A() {
		super();
//		super();  //compiler error
	}

	 A(int a) {
		System.out.println("A with arg a");
//		this();  //compiler error
	}
	 
	 protected A(String s){
		 this();
		 new A();  //ok but redundant
		 new A(5);
//		 this(3);  //compiler error
	 }
	 
	 
	
	
}
