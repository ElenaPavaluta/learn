package oc.p.chapters._3_GenericsAndCollections.workingWithGenerics.genericInterfaces.interfaceMethods.defaulT;

interface Ship<T>
{

	default T m(T t)
	{
		System.out.println("default createAndPopulate method in interface Ship");
		return t;
	}

	default <T> T m2(T t)  //in this case T in the overriden method is not replaced with the supplied dbType
	{
		return null;
	}

	default <T, Q> T m3(T t, Q q)
	{
		return null;
	}
}
