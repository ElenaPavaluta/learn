package chapters.c4_methods_and_encapsulation.overloadingMethods;


/**
 * Everything other than the method signature can vary for overloaded methods.
 * This means there can be different access modifiers, specifiers (like static),
 * return types, and exception lists.
 *
 */
public class OverloadingMethods {

	public boolean fly() {
		return false;
	}

	void fly(int numOfKm) {
		System.out.println("int");
	};

	protected void fly(short numMeters) {
		System.out.println("short");
	};

	private void fly(int numKm, short numOfMeters) throws Exception {
	};

	
	public static void main(String[] args) {
		OverloadingMethods om = new OverloadingMethods();
		
		om.fly(0);  //int
		om.fly((short)0);  //short
	}
}

