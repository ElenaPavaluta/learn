package oc.a.chapters._3_core_java_apis.javaArrays;

import java.util.Arrays;

public class Varargs {

	static void print(String... strings) {
		System.out.println(Arrays.toString(strings));
	}

	static void print(int... ia) {
		System.out.println(Arrays.toString(ia));
	}

	public static void main(String[] args) {
		print(args);
		
		print(new int[]{1,2,3});
		
		print(new int[3]);
		
//		print (new int[]);
//		print({1,2,3});
		
		print(1);
	}
}
