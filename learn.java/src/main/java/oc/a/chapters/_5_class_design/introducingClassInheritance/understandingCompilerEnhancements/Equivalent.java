package oc.a.chapters._5_class_design.introducingClassInheritance.understandingCompilerEnhancements;

public class Equivalent {

	//defaulT no args constructor
	class Donkey {

	}

	//defined no args constr, defaulT call to super
	class Donkey2 {
		public Donkey2() {
		}
	}

	//defined no args constr and explicit call to super();
	class Donkey3 {
		public Donkey3() {
			super();
		}
	}

}
