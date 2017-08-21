package oc.a.chapters.c2_operators_and_statements.understandingAdvancedFlowControl;

/**
 * 
 * optionalLabel: while (booleanExpression){ ....
 * 
 * //somewhere in loop 
 * break optionalLabel; }
 * 
 * 
 * The break statement transfers the flow of control out to the enclosing statements; terminates the current loop
 */
public class TheBreakStatement {
	
	static void m() {
		int[][] list = { { 1, 13, 5, }, { 1, 2, 5 }, { 2, 7, 2 }, };
		int searchedValue = 2;
		int pozX = -1;
		int poxY = -1;

		PARENT_LOOP: for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[i].length; j++) {
				if (list[i][j] == searchedValue) {
					pozX = i;
					poxY = j;
//					break PARENT_LOOP;  //searches for the first appearance of the searched value
					break;   //searches for the last appearance of the searched value
				}
			}
		}

		if (pozX == -1 || poxY == -1) {
			System.out.println("Value " + searchedValue + " not found");
		} else {
			System.out.println("Value " + searchedValue + ", fount at: i = "
					+ pozX + " and j = " + poxY);
		}
	}

	public static void main(String[] args) {
		m();
	}
}
