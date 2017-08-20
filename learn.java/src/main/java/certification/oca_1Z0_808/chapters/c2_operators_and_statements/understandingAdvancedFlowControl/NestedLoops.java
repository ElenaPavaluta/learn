package chapters.c2_operators_and_statements.understandingAdvancedFlowControl;

public class NestedLoops {

	static int[][] xaa = { { 5, 2, 3, 1 }, { 3, 9, 8, 9 }, { 5, 7, 12, 7 } };

	static void m() {
		for (int[] xa : xaa) {
			for (int i = 0; i < xa.length; i++) {
				System.out.print(xa[i] + "\t");
			}
			System.out.println();
		}
	}

	static void m2() {
		int x = 20;
		while (x > 0) {
			do {
				x -= 2;
			} while (x > 5);
			x--;
			System.out.print(x + "\t");  //3 0
		}
	}

	public static void main(String[] args) {
		m();
	}
}
