package chapters.c3_usingOperatorsAndDecisionConstructs.q50;

class Baby {

	static String m(int toy, int age) {
		final String game;

		if (toy < 2)
			game = age > 1 ? "" + 1 : "" + 10;
		else
			game = age > 3 ? "ball" : "swim";
		return game;
	}
	
	public static void main(String[] args) {
		System.out.println(m(5, 2));  //swim
	}
	
}
