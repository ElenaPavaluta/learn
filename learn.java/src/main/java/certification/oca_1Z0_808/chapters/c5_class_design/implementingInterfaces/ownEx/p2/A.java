package chapters.c5_class_design.implementingInterfaces.ownEx.p2;

import chapters.c5_class_design.implementingInterfaces.ownEx.p.IA;
import chapters.c5_class_design.introducingClassInheritance.inheritingMethods.overridingAMethod.ownEx.ExceptionB;

public class A extends AA {

	@Override
	public void mia() {
		System.out.println(IA.I);
		System.out.println(AA.I);
		System.out.println(this.I);
		System.out.println(super.I);
	}

	void m() {
		this.mia();
		try {
			super.mia();
		} catch (ExceptionB e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		A a = new A();

		a.m();
	}

}
