package chapters.c2_operators_and_statements.unaryOperators;

/**
 * e++/ e--: evaluated to the original value, although the value in e get's changed
 * ++e/ --e: evaluated to the value of e, which get's changed  
 *
 */
public class IncremenetAndDecrementOperators {

	static void m() {
		int x = 3;
		int y = ++x * 5 / x-- + --x;

		System.out.println(y);
	}

	static void m2(){
		int x = 5;
//		--x++;  //compiler error
	}
	
	public static void main(String[] args) {
		m();
	}
	
	
}
