package oc.p.chapters.c1_AdvancedClassDesign.workingWithEnums.addingContructorFieldsMethods;

enum E
{
	ONLY_ONCE(true);

	E(boolean b)  //public and protected -> compiler error:
	{
		System.out.println("E constructor called at ");
	}

	public static void main(String[] args)
	{
		E e = E.ONLY_ONCE;
		E e2 = ONLY_ONCE;
		//		E e3 = new E(false);  //compiler error: an enum can not be instantiated. The enum values are like static final variables
	}
}
