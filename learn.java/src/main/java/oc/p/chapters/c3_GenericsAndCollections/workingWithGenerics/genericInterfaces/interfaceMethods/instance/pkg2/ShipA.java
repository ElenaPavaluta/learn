package oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.genericInterfaces.interfaceMethods.instance.pkg2;

import oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.Robot;


class ShipA implements Ship<Robot>
{
	@Override public Robot m(Robot robot)
	{
		return null;
	}

	@Override public <T> T m2(T t)
	{
		return null;
	}

	@Override public <T, Q> T m3(T t, Q q)
	{
		return null;
	}
}
