package chapters.c5_class_design.introducingClassInheritance.inheritingMethods.overridingAMethod.ownEx;

import utils.delimitators.Delimitators;

public class Run {

	public static void main(String[] args) {
		O o = new O();

		O o2 = new O2();
		O2 o22 = new O2();

		O o3 = new O3();
		O3 o33 = new O3();

		try {
			o.m(5); // O
			o.ms(); // O ms
		} catch (ExceptionA e) {
			e.printStackTrace();
		}

		Delimitators.equal();

		try {
			o2.m(5); // O2
			o2.ms(); // O ms
		} catch (ExceptionA e) {
			e.printStackTrace();
		}
		Delimitators.equal();

		try {
			o22.m(5); // O2
			o22.ms(); // O2 ms
		} catch (ExceptionB e) {
			e.printStackTrace();
		}

		Delimitators.equal();
		try {
			o3.m(5); // O3
			o3.ms(); // O ms
		} catch (ExceptionA e) {
			e.printStackTrace();
		}
		Delimitators.equal();

		o33.m(5); // O3
		o33.ms(); // O3 ms
	}
}
