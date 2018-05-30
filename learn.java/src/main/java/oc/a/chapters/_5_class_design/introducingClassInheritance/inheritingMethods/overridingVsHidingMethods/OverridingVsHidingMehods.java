package oc.a.chapters._5_class_design.introducingClassInheritance.inheritingMethods.overridingVsHidingMethods;

import oc.a.chapters._5_class_design.introducingClassInheritance.inheritingMethods.overridingVsHidingMethods.hidden.Kangaroo;

/**
 * At runtime the child version of an overridden method is always executed for
 * an instance regardless of whether the method call is defined in a parent or
 * child class method. In this manner, the parent method is never used unless an
 * explicit call to the parent method is referenced, using the syntax
 * ParentClassName.method(). Alternatively, at runtime the parent version of a
 * hidden method is always executed if the call to the method is defi ned in the
 * parent class.
 *
 */
public class OverridingVsHidingMehods {

	// hidden
	static void m() {
		Kangaroo k = new Kangaroo();
		k.getMarsupialDesc(); // marsupial: false
		k.getKangarooDesc(); // Kangaroo: true
	}

	// override
	static void m2() {
		oc.a.chapters._5_class_design.introducingClassInheritance.inheritingMethods.overridingVsHidingMethods.overriden.Kangaroo k = new oc.a.chapters._5_class_design.introducingClassInheritance.inheritingMethods.overridingVsHidingMethods.overriden.Kangaroo();
		k.getMarsupialDesc(); // marsupial: true
		k.getKangarooDesc(); // Kangaroo: true
	}

	public static void main(String[] args) {
		m();
		m2();
	}
}
