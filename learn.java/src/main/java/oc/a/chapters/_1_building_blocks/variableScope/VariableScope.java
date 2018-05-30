package oc.a.chapters._1_building_blocks.variableScope;

public class VariableScope {

	static void eat(int piecesOfCheese) {
		// int piecesOfCheese = 1; //compiler error: duplicate local variable:
		// piecesOfCheese
	}

	static void eatIfHungry(boolean hungry) {
		if (hungry) {
			int piecesOfCheese = 1;
		}// piecesOfCheese goes out of scope here

		// System.out.println(piecesOfCheese); // does not compile:
		// piecesOfCheese it's out of scope
	}

	/*
	 * {} Blocks can contain other blocks: {{} {}}. The smaller contained blocks
	 * can reference variables defined in the larger scoped blocksm but not vice
	 * versa
	 */

	static void blocks() {
		int a;

		{
			int b;
			{
				// System.out.println(a); // does not compile: the a var hasn't
				// been initialized so far;
				// System.out.println(c); // does not compile: c hasn't been
				// declared (and initialized) so far
				int c;
				{
					int d;
					a = 1;
					// System.out.println(a); //does not compile till a it's
					// initialized
				}
			}
		}
		System.out.println(a);
	}

	static void eatIfHungry2(boolean hungry) {
		if (hungry) {
			int bitesOfCheese = 1;
			{
				boolean tinyBit = true;
				System.out.println(bitesOfCheese);
			}
//			System.out.println(tinyBit); // compiler error: out of scope
		}
	}
	
	static void eatMore(boolean hungry, int amaountOfFood){
		int roomInBelly = 5;
		if(hungry){
			boolean timeToEat = true;
			while(amaountOfFood > 0){
				int amountEaten = 2;
				roomInBelly = roomInBelly-amaountOfFood;
				amaountOfFood = amaountOfFood - amountEaten;
			}
		}
		System.out.println(amaountOfFood);
	}
}
