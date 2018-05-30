package oc.p.chapters._3_GenericsAndCollections.workingWithGenerics.genericInterfaces.interfaceMethods.statiC;

interface Ship<T>
{
	/**
	 * Compiler error:
	 * T is going to be replaced with the actual type in the implementing class
	 * T can not be referenced from a static context
	 * (This is not allowed because the type is linked to the instance of the class)
	 */
	//		static T m(T t){
	//		return  null;
	//	}

	static <T> T m2(T t)
	{
		return null;
	}

	static <T, Q> T m3(T t, Q q)
	{
		return null;
	}
}
