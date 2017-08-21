package days.d5_7.t3.q4;

public class Q4 {

	private String value;

	void go() {
		try {
			System.out.println(value.toString());
			System.out.println(1);
		} catch (NullPointerException e) {
			System.out.println(2);
			System.exit(0);
		} finally {
			System.out.println(3);
		}
		System.out.println(4);
	}

	protected void protectedM(){
		System.out.println("Q4 protected method");
	}
	
	public static void main(String[] args) {
		Q4 q = new Q4();

		System.out.println(q.value);

		q.go();
	}
}
