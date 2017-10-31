package oc.p.chapters.c2_PatternsAndPrinciples.introducingFunctionalProgramming.definingAFunctionalInterface;

/**
 * A functional interface is an interface for which just one single instance method is defined
 * One can choose to use or not the @FunctionalInterface annotation.
 * A functional interface annated with the specific annotation would raise a compiler error if one will add another instance
 * method
 */
@FunctionalInterface interface FunctionalI
{
	int a = 007;

	static void staticM()
	{
	}

	default void m()
	{
	}

	boolean action();

//	boolean action2();  //compiler error
}
