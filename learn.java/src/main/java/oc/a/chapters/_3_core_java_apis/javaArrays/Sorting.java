package oc.a.chapters._3_core_java_apis.javaArrays;

import java.util.Arrays; //import just Arrays

public class Sorting {
	static void m() {
		int numbers[] = new int[] { 6, 9, 1, };
		Arrays.sort(numbers);
		System.out.println(Arrays.toString(numbers));

		String[] strings = { "10", "9", "100" };
		Arrays.sort(strings);
		System.out.println(Arrays.toString(strings)); // ["10", "100", "9"]
														// String sorts in
														// alphabetic order, and
														// 1 sorts before 9.
														// (Numbers sort before
														// letters and uppercase
														// sorts before
														// lowercase, in case
														// you were wondering.)
	}

	public static void main(String[] args) {
		m();
	}
}
