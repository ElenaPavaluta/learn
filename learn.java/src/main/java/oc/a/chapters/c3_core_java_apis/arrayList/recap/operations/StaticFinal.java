package oc.a.chapters.c3_core_java_apis.arrayList.recap.operations;

import java.util.ArrayList;
import java.util.List;

class StaticFinal {

	static final List<String> lst = new ArrayList<>(); 

	final List<String> lst2;

	static {
		/*
		 * Ok
		 */
//		 lst = new ArrayList<>();
		
		/*
		 * Only a static variable can be initialized in a static block
		 */
//		lst2 = new ArrayList<>();
	}

	{
		/*
		 * Being static and final can't be instantiated here; the final keyword
		 * ensures that once a variable it's initialized, it can't chance it's
		 * value
		 */
		// lst = new ArrayList<>();

		/*
		 * Legal because lst2 variable belongs to an instance of this class, not
		 * to the class as a static variable
		 */
//		lst2 = new ArrayList<>();
	}

	public StaticFinal() {
		/*
		 * Ok
		 */
		// super();

		/*
		 * Compiler error: recursive constructor invocation
		 */
		// this();

		/*
		 * compiler error: the variable is static and final and the constructor
		 * runs for every instance of the class
		 */
//		lst = new ArrayList<>();
		
		/*
		 * Would be ok if it wouldn't have been initialized till this point
		 */
		lst2 = new ArrayList<>();
		
	}

}
