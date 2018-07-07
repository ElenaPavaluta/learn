package oc.a.chapters._2_operators_and_statements.statements;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * for(initialization; boolean expression; update statement){ //curly braces
 * required for multiple statements }
 *
 * 1. initialization part executes 2. if boolean expression is true, else exit
 * loop 3. body executes 4. execute update statement 5. return to step 2
 */
public class ForStatement {

	static void m() {
		for (int i = 0; i < 5; i++)
			System.out.println(i);
		// System.out.println(i); //compile time error: i it's out of scope
	}

	static void m2() {
		int i = 0;
		for (; i < 5; i++) {
			System.out.println(i);
		}
		System.out.println(i); // i = 5; At the 6th iteration the value of i has
								// been already updated by the 5th iteration,
								// the condition it's checked: returns false so
								// the loop is not executed
	}

	/*
	 * An infinite loop
	 */
	static void m3() {
		for (;;) {
			System.out.println("I can run forever");
		}

		// for(){} //compile time eror: requires ; ;
	}

	/*
	 * Adding multiple terms
	 */
	static void m4() {
		int x = 0;
		for (long y = 0, z = 4; x < 5 && y < 10; x++, y++) {
			System.out.print(y + " "); // prints: 0 1 2 3 4
		}
		System.out.println(x); // 5
	}

	/*
	 * Redeclaring a variable in the initialization block
	 */
	static void m5() {
		int x = 0;
		// for (long y = 0, x = 4; x < 5 && y < 10; x++, y++) {}

		// compile time
		// error: duplicate variable x;
	}

	/*
	 * Using incompatible data types in the initialization part
	 */
	static void m6() {
		// for(long y = 0, int x = 4; x<5 && y<10; i++, y++){}

		// compile time error: The variables in the initialization block must
		// all be of the
		// same dbType
	}

	static void m7() {
		for (int x = 0, xa[] = { 1, 2, 3, }; x < xa.length; x++) {
			System.out.print(xa[x] + " ");  //1 2 3 
		}
	}
	
	/**
	 * 8 ^ 9
	 */
	static void m8(){
		int a, b[], c;
		for(int i = 0, ia[] = {1, 2, 3}, iaa[][]= {{}, {1}, {1,2}, {1,2,3}}; i<4; a = ia[1], b = iaa[2], c = iaa[2][0], i++){
			System.out.print(i);  //0 1 2 3
		}
	}
	
	static void m9(){
		int i;
		float f;
		Date d;
		Map<String, String> map;
		
		for(i = 0, f = 0f, d = new Date(), map = new HashMap<String, String>(); i<5; i++){
			//
		}
		map.put(String.valueOf(i), String.valueOf(i));
		System.out.println(map.get(String.valueOf(i)));
	}

	public static void main(String[] args) {
		// m3();
//		m4();
//		m7();
//		m8();
		m9();
	}
}
