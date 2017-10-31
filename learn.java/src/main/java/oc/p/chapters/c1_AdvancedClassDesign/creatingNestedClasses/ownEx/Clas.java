package oc.p.chapters.c1_AdvancedClassDesign.creatingNestedClasses.ownEx;

class Clas
{
	class C
	{
		void m()
		{
		}


		// static void staticM(){}
		/** Compiler error: inner classes can not have static methods or member, but the inner classes defined inside an
		 * interface can
		 */
	}
}
