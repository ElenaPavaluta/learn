package days.d5_18.t;

class T {

	short i = 2;
	
	{
		i++;
	}
	
	
	static void m(){
		int j = 5;
		int x = j++;
		
		System.out.println(x);
		System.out.println(j);
	}
	
	public static void main(String[] args) {
//		m();
		System.out.println(-1%3);
	
	}
}
