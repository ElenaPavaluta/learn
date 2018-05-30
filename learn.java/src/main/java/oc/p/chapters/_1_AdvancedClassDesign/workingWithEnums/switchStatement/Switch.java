package oc.p.chapters._1_AdvancedClassDesign.workingWithEnums.switchStatement;

class Switch
{

	static void m(Seasons s)
	{
		switch (s)
		{
			case FALL:
				System.out.println("fall");
				break;
//			case SUMMER.SPRING:  //compiler error
		}
	}

	static enum Seasons  //can be also private
	{
		SPRING, SUMMER, FALL, WINTER
	}
}
