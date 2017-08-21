package oc.a.chapters.c4_methods_and_encapsulation.varargs;

/**
 * A vararg parameter must be the last element in a method�s parameter list.
 *
 */
public class Varargs {

	static void walk(int start, int... nums) {
		System.out.println(nums.length);
	}

	static void walk2(int... arr) {
		System.out.println(arr[3]);
	}

	public static void main(String[] args) {
		walk(1); // 0

		walk(1, 2); // 1

		walk(1, 2, 3, 4, 5); // 4

		walk(1, new int[] { 2, 3, 4, 5 }); // 4

		walk2(new int[] { 2, 3, 4, 5 }); // 5

		walk2(); // throws NullPointerException as would an array when trying to
					// access a unexisting index
	}

}
