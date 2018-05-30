package oc.p.chapters._3_GenericsAndCollections.workingWithGenerics.genericInterfaces.interfaceMethods.instance.pkg;

public class ShipC<X, Y> implements Ship<X, Y>
{

	@Override public X m(Y y)
	{
		return null;
	}

	@Override public <T> T m2(Y y)
	{
		return null;
	}

	@Override public <V> V m3(X x, Y y)
	{
		return null;
	}

	@Override public <T, Q> T m4(Y y, Q q)
	{
		return null;
	}
}
