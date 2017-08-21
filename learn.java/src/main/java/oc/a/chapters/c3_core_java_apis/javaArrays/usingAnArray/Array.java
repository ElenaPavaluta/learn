package oc.a.chapters.c3_core_java_apis.javaArrays.usingAnArray;

import java.util.Arrays;

public class Array {

	static String[] mammals = { "monkey", "chimp", "donkey" };

	static void m() {
		System.out.println(mammals.length);
		System.out.println(mammals[0]);
		System.out.println(mammals[1]);
		System.out.println(mammals[2]);
	}

	static void m2() {
		String[] birds = new String[6];
		System.out.println(birds.length); // 6
	}

	static void m3() {
		int numbers[] = new int[10];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = numbers[i] + 5;
		}
	}

	static void m4() {
		int[] a = new int[3];

		System.out.println(Arrays.equals(a, null)); // false
	}

	public static void main(String[] args) {
		// m();
		// m2();

		m4();
	}
}
