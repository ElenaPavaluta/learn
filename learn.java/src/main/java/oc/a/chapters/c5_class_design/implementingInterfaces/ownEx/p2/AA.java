package oc.a.chapters.c5_class_design.implementingInterfaces.ownEx.p2;

import oc.a.chapters.c5_class_design.implementingInterfaces.ownEx.p.IA;
import oc.a.chapters.c5_class_design.introducingClassInheritance.inheritingMethods.overridingAMethod.ownEx.ExceptionB;

public abstract class AA implements IA /* , IB (not vizible) */ {

	@Override
	public void mia() throws ExceptionB/* throws ExceptionA (override) */ {
		throw new ExceptionB("EB");
	}

}
