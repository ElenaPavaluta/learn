package chapters.c4_creatingAndUsingArrays.q16;

import java.util.Arrays;

class Q {

	static void m(){
		String[][] matrix = new String[1][2];
		
		matrix[0][0] = "[0][0]";
		matrix[0][1] = "[0][1]";
//		matrix[1][0] = "[1][0]";  //throws IndexOutOfBoundsException
//		matrix[1][1] = "[1][1]";  //throws IndexOutOfBoundsException
		
		System.out.println(Arrays.toString(matrix[0]));
	}
	
	
	public static void main(String[] args) {
		m();
	}
	
}
