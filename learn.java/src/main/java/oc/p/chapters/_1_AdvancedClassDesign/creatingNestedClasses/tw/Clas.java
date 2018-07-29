package oc.p.chapters._1_AdvancedClassDesign.creatingNestedClasses.tw;

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
