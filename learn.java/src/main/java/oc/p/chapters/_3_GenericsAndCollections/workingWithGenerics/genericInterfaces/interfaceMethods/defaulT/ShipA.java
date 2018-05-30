package oc.p.chapters._3_GenericsAndCollections.workingWithGenerics.genericInterfaces.interfaceMethods.defaulT;



import oc.p.chapters._3_GenericsAndCollections.workingWithGenerics.Robot;


class ShipA implements Ship<Robot>
{
	public static void main(String[] args)
	{
		ShipA s = new ShipA();
		s.m(null);
	}

	@Override public Robot m(Robot robot)
	{
				return Ship.super.m(robot);
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
