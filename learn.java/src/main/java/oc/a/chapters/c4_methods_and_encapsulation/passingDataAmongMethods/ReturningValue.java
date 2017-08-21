package oc.a.chapters.c4_methods_and_encapsulation.passingDataAmongMethods;

public class ReturningValue {

	public static void main(String[] args) {
		int number = 1;
		String letters = "abc";
		number(number);
		letters = letters(letters);
		System.out.println(number + letters); // 1abcd
	}

	private static int number(int number) {
		number++;
		return number;
	}

	private static String letters(String letters) {
		letters += "d";
		return letters;
	}
}
