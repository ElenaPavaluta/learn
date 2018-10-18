package oc.a.chapters._6_exceptions.recognizingCommonExceptionTypes.runtimeExceptions;

class ArrayIndexOutOfBoundsException {

	static void m() {
		int[] arr = new int[3];
		System.out.println(arr[0]);
		System.out.println(arr[3]);
	}

	static void m2() {
		int arr[] = new int[] { 1, 2, 3 };
		int t = 0;

		for (int i = 0; i <= arr.length; i++) { // the condition should be
												// i<arr.lenght
			t += arr[i];
		}
	}

	public static void main(String[] args) {
		// createAndPopulate();
		m2();
	}

}
