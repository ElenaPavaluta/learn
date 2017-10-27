package oc.p.chapters.c1_AdvancedClassDesign.workingWithEnums.switchStatement;

import static oc.p.chapters.c1_AdvancedClassDesign.workingWithEnums.switchStatement.Switch.Seasons;


class Run
{
	static void m(Seasons s)
	{
		switch (s)
		{
			case SUMMER:
				break;
		}
	}

	static void m2()
	{
		Seasons s = Seasons.SUMMER;

		System.out.println(s == Seasons.SUMMER);  //it's legal. The enum values are like static final variables. More, if
		// there' a construcor it's going to be called just once when the first time the enum is used. Just like the singleton
		// pattern
	}
}
