package oc.a.chapters._5_class_design.implementingInterfaces.inheritingAnInterface.case2;

public class C implements IO, IH {

	@Override
	public int eatPlants(int a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void eatPlants() {
		// TODO Auto-generated method stub

	}

	/*
	 * Although this method is defined both in IO and IH interfaces, it's
	 * implemented only once because an abstract method (one defined either in
	 * an interface or an abstract class) defines the behavior that the
	 * implementing class must have
	 */
	@Override
	public void m() {
		// TODO Auto-generated method stub

	}
}
