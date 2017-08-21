package oc.a.chapters.c2_operators_and_statements.statements;

/**
 * 
 * while(boolean expression){ (curly braces are optional for single stament) }
 */

/*
 * A statement it's terminated by the ; (semicolon)
 */
public class WhileStatement {

	static void eatCheese(int bitesOfCheese) {
		int roomInBelly = 5;
		while (bitesOfCheese > 0 && roomInBelly > 0) {
			bitesOfCheese--;
			roomInBelly--;
			System.out.println("still hungry");
		}
		System.out.println("not hungry any more");
	}

	/*
	 * beware: infinite loops
	 */
	static void m() {
		int x = 2;
		int y = 5;
		while (x<10) {
			y++;
		}
	}

	
	public static void main(String[] args) {
		eatCheese(5);
	}
}
