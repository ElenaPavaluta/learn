package chapters.c3_usingOperatorsAndDecisionConstructs.q42;

class TestGame {

	String runTest(boolean spinner, boolean roller){
		if(spinner = roller) return "up";
		else return roller? "down":"middle";
	}
	
	public static void main(String[] args) {
		String s = new TestGame().runTest(false, true);  //up
		System.out.println(s);
	}
}
