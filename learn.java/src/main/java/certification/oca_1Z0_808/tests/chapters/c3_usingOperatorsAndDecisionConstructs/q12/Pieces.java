package chapters.c3_usingOperatorsAndDecisionConstructs.q12;

class Pieces {

	public static void main(String[] args) {

		int flair = 15;
		if (flair >= 15 && flair < 37) {
			System.out.println("Not enough");
		}
		if (flair == 37) {
			System.out.println("Just right");
		} else {
			System.out.println("Too many");
		}

	}
}
