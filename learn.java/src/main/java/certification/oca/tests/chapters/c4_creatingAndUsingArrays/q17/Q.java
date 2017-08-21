package chapters.c4_creatingAndUsingArrays.q17;

import java.util.Arrays;

class Q {

	static void m(){
		String os[] = {"Mac", "Linux", "Windows"};
		
		Arrays.sort(os);
		
		System.out.println(Arrays.binarySearch(os, "Mac"));
	}
	
	
	public static void main(String[] args) {
		m();
	}
}
