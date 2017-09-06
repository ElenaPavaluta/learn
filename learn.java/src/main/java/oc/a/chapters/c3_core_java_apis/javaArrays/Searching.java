package oc.a.chapters.c3_core_java_apis.javaArrays;

import java.util.Arrays;

/**
 * Java also provides a convenient way to search�but only if the array is
 * already sorted.
 *
 */
public class Searching {

	static int[] numbers = { 8, 5, 3, 7, 4, 5, 6, 1, 0 };

	static int numbers2[] = new int[] { 1, 3, 5, 7, 9, };

	static {
		Arrays.sort(numbers);
		// System.out.println(Arrays.toString(numbers));
	}

	/*
	 * Binary search rules:
	 */

	/*
	 * 1. Element found in sorted array: index of match
	 */
	static void m() {
		System.out.println(Arrays.binarySearch(numbers, 5)); // 4
	}

	/*
	 * 2. Target element not founded in sorted array: Negative value showing one
	 * smaller than the negative of index, where a match needs to be inserted to
	 * preserver the sorded order
	 */
	static void m2() {
		System.out.println(Arrays.toString(numbers));
		System.out.println(Arrays.binarySearch(numbers, 9)); // -10

		System.out.println(Arrays.binarySearch(numbers2, 6)); //-4
		
		System.out.println(Arrays.binarySearch(numbers2, 0));  //-1
		
		System.out.println(Arrays.binarySearch(numbers2, 8));  //-5
	}

	/*
	 * Unsorted array: the result isn't predictable
	 */
	static void m3() {
		int[] numbers = { 8, 5, 3, 7, 4, 5, 6, 1, 0 };
		System.out.println(Arrays.binarySearch(numbers, 9));
	}

	public static void main(String[] args) {
//		m();
		m2();
//		m4();
	}
}
