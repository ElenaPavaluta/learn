package oc.a.chapters.c5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.override;

import oc.a.chapters.c5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.C;

/**
 * Because the method defaulT m() has the same signature both in IA and IB,
 * we're getting a compiler error, and we need to override the m method
 *
 */
public interface IAB extends IA, IB {

	@Override
	default C m() {
		return new C();
	}

}
