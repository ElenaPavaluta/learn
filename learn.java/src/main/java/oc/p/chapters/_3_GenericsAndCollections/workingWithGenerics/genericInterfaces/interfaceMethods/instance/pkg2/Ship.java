package oc.p.chapters._3_GenericsAndCollections.workingWithGenerics.genericInterfaces.interfaceMethods.instance.pkg2;

interface Ship<T>
{
	T m(T t);

	<T> T m2(T t);

	<T, Q> T m3(T t, Q q);
}
