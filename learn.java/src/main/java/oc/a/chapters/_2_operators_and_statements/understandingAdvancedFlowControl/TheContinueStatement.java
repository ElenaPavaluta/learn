package oc.a.chapters._2_operators_and_statements.understandingAdvancedFlowControl;

/**
 * 
 * optionalLabel: while(booleanCondition){
 * 
 * //somewhere in loop continue optionalLabel; }
 * 
 * The continue statement ends the current iteration of the loop
 */
public class TheContinueStatement {

	static void m() {
		FIRST_CHAR_LOOP: for (int a = 1; a <= 4; a++) {
			for (char x = 'a'; x <= 'c'; x++) {
				if (a == 2 || x == 'b') {
					continue FIRST_CHAR_LOOP;  // 1a 3a 4a
//					continue;  // 1a 1c 3a 3c 4a 4c
				}
				System.out.println(" " + a + x); 
			}									
		}
	}
	
	public static void main(String[] args) {
		m();
	}
}
