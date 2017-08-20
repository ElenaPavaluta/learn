package chapters.c4_creatingAndUsingArrays.q10;

import java.util.Arrays;

class Q {

	static void m(){
		String[] nums = new String[]{"1", "9", "10"};
		Arrays.sort(nums);
		
		System.out.println(Arrays.toString(nums));
	}
	
	public static void main(String[] args) {
		m();
	}
}
