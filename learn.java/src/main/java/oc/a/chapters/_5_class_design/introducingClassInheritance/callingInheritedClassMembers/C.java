package oc.a.chapters._5_class_design.introducingClassInheritance.callingInheritedClassMembers;

public class C extends B {

	protected int b = 11;
	protected int c = 9;

	protected void mc() {
		System.out.println(super.b); // 11
		System.out.println(this.b); // 7

		System.out.println(super.a); // 5
		System.out.println(this.a); // 5
	}

	protected void mc2() {
		this.ma();
		this.mb();

		super.ma();
		super.mb();
	}

	public static void main(String[] args) {
		C c = new C();

		c.mc();
		c.mc2();
	}
}
