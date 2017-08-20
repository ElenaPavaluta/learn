package chapters.c2_operators_and_statements.understandingAdvancedFlowControl;

/**
 * 
 * Can have optional labels: 
 * 	if-then statements 
 * 	switch statements
 * 	loops
 *
 *
 * A label is an optional pointer to the head of a statement that allows the
 * application flow to jump to it or break from it. It is a single word that is
 * proceeded by a colon (:).
 */
public class AddingOptionalLabels {
	static int[][] xaa = { { 5, 2, 3, 1 }, { 3, 9, 8, 9 }, { 5, 7, 12, 7 } };

	static void m() {
		OUTER_LOOP: for (int[] xa : xaa) {
			INNVER_LOOOP: for (int i = 0; i < xa.length; i++) {
				System.out.print(xa[i] + "\t");
			}
			System.out.println();
		}
	}
}
