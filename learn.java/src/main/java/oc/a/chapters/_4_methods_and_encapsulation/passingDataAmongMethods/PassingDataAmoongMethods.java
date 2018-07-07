package oc.a.chapters._4_methods_and_encapsulation.passingDataAmongMethods;

/**
 * Java is a �pass-by-value� language. This means that a copy of the variable is
 * made and the method receives that copy.
 *
 */
public class PassingDataAmoongMethods {

	void m(int i) {
		i = 007;
	}

	void m2(String s) {
		s = "new String";
	}

	void m3(StringBuilder sb) {
		sb.append("added by SB");
	}

	void m4(StringBuilder sb) {
		sb = new StringBuilder().append("new Sb");
	}

	public static void main(String[] args) {
		PassingDataAmoongMethods c = new PassingDataAmoongMethods();

		int i = 0xA;
		c.m(i);
		System.out.println(i); // 10, the value in i is not changed

		String s = "ha ha, I'createAndPopulate immutable";
		c.m2(s); // the actual parameter is a copy of the s reference
		System.out.println(s); // ha ha, I'createAndPopulate immutable;

		StringBuilder sb = new StringBuilder();
		c.m3(sb);
		System.out.println(sb); // added by SB

		sb = new StringBuilder("actual SB");
		c.m4(sb);
		System.out.println(sb); // actual SB
	}
}

