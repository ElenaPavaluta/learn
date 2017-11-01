package oc.p.chapters.c2_PatternsAndPrinciples.introducingFunctionalProgramming;

import java.util.function.Predicate;


class Run
{
	static Animal[] animals = { new Animal("walk", false, true), new Animal("swim", true, false) };

	static void old(Animal[] animals, Old o)
	{
		for (Animal a : animals)
		{
			if (o.action(a))
			{
				System.out.println(a.getName());
			}
		}
	}

	static void predicate(Animal[] animals, Predicate<Animal> predicate)
	{
		for (Animal a : animals)
		{
			if (predicate.test(a))
			{
				System.out.println(a.getName());
			}
		}
	}

	public static void main(String[] args)
	{
		old(animals, new Old.CanSwim());

		predicate(animals, a -> a.isWalk());
		predicate(animals, a -> a.isSwim());

		predicate(animals, (Animal a) -> a.isSwim());
		predicate(animals, (Animal a) -> {
			return a.isSwim();
		});
	}
}
