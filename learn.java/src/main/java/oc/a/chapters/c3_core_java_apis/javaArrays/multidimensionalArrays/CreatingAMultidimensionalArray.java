package chapters.c3_core_java_apis.javaArrays.multidimensionalArrays;

import java.util.Arrays;

public class CreatingAMultidimensionalArray {

	// define
	int[][] vars;

	int vars2[][];

	int[] vars3[];

	int[] vars4, vars5[][], vars6[][][];

	// init
	{
		vars = new int[3][];
		vars = new int[3][1];
		int[][] temp = { { 1 }, { 1, 2 }, { 1, 2, 3 } };

		temp = new int[][] { { 1 }, { 1, 2 }, { 1, 2, 3 } };

		// vars = new int[][]; //compiler error
		// vars = {{1}, {1,2}, {1,2,3}}; //compiler error
		// vars= new int[][2]; //compiler error
	}

	{
		vars6 = new int[2][][][];
		System.out.println(Arrays.toString(vars6));

		vars6 = new int[2][3][4][5];
		System.out.println(Arrays.toString(vars6));
	}

	public static void main(String[] args) {
		CreatingAMultidimensionalArray a = new CreatingAMultidimensionalArray();
		int[][][][] arr = a.vars6;
		
		for(int i = 0; i<arr.length; i++){
			for(int j = 0; j<arr[i].length; j++){
				for(int k = 0; k<arr[i][j].length; k++){
					System.out.println(Arrays.toString(arr[i][j][k]));
				}
			}
		}
	}
}
