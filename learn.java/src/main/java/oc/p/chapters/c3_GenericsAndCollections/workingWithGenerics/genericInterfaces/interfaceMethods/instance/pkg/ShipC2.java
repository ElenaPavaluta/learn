package oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.genericInterfaces.interfaceMethods.instance.pkg;

import gtk.designPatterns.creational.builder.Robot;
import oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.Robot2;


class ShipC2 extends ShipC<Robot, Robot2>
{
	@Override public Robot m(Robot2 robot2)
	{
		return super.m(robot2);
	}

	@Override public <T> T m2(Robot2 robot2)
	{
		return super.m2(robot2);
	}

	@Override public <V> V m3(Robot robot, Robot2 robot2)
	{
		return super.m3(robot, robot2);
	}

	@Override public <T, Q> T m4(Robot2 robot2, Q q)
	{
		return super.m4(robot2, q);
	}
}
