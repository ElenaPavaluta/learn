package oc.p.chapters.c1_AdvancedClassDesign.creatingNestedClasses.innerClass.member;

class RunOuterVar
{
	public static void main(String[] args)
	{
		OuterVar ov = new OuterVar();
		ov.m();

		OuterVar.Inner ovi = ov.new Inner();
		ovi.innerM();
		ovi.innerM2();
	}
}
