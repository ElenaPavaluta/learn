package days.d5_7.t;

public class T10 {

	static void m(){
		int[] arr = {15, 30, 45, 60, 75};
		
		arr[2] = arr[4];
		arr[4] = 90;
		
		for(int i = 0; i<arr.length; i++){
			System.out.println(arr[i]);
		}
	}
	
	public static void main(String[] args) {
		m();
	}
}
