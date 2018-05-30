package oc.p.chapters._2_PatternsAndPrinciples.introducingFunctionalProgramming;

class Animal
{
	String name;
	boolean swim;
	boolean walk;

	Animal(String name, boolean swim, boolean walk)
	{
		this.name = name;
		this.swim = swim;
		this.walk = walk;
	}

	String getName()
	{
		return name;
	}

	boolean isSwim()
	{
		return swim;
	}

	boolean isWalk()
	{
		return walk;
	}
}
