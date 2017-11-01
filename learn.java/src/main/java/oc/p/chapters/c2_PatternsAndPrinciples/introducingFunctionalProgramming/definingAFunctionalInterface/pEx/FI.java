package oc.p.chapters.c2_PatternsAndPrinciples.introducingFunctionalProgramming.definingAFunctionalInterface.pex;

import java.time.LocalDate;


@FunctionalInterface
interface FI
{
	boolean m();

	@FunctionalInterface
	interface I{
		void m(String a);
	}

	@FunctionalInterface
	interface I2{
		boolean m(LocalDate ld, String s);
	}
}
