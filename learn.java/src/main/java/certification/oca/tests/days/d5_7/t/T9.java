package days.d5_7.t;

class T9 {

	static void m() {
		int x = 100;
		int a = x++;

		System.out.println("a: " + a); // 100
		System.out.println("x: " + x); // 101

		int b = ++x; // b = 102, x = 102
		System.out.println("b: " + b); // 102
		System.out.println("x: " + x); // 102

		int c = x++;
		System.out.println("c: " + c); // 102
		System.out.println("x:" + x); // 103
		
//		int d = (a<b) ? (a<c)? a: (b<c)?b:c; //compilation fail
		

	}
	
	
	public static void main(String[] args) {
		m();
	}
}
