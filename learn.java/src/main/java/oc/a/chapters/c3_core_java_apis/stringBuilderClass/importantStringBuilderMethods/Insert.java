package oc.a.chapters.c3_core_java_apis.stringBuilderClass.importantStringBuilderMethods;

/**
 * 
 * StringBuilder insert(int offset, boolean b)
 * 
 * StringBuilder insert(int offset, char c)
 * 
 * StringBuilder insert(int offset, char[] str)
 * 
 * StringBuilder insert(int index, char[] str, int offset, int len)
 * 
 * StringBuilder insert(int dstOffset, CharSequence s)
 * 
 * StringBuilder insert(int dstOffset, CharSequence s, int start, int end)
 * 
 * StringBuilder insert(int offset, double d)
 * 
 * StringBuilder insert(int offset, float f)
 * 
 * StringBuilder insert(int offset, int i)
 * 
 * StringBuilder insert(int offset, long l)
 * 
 * StringBuilder insert(int offset, Object obj)
 * 
 * StringBuilder insert(int offset, String str)
 * 
 */

public class Insert {

	static char[] ca = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	/*
	 * StringBuilder insert(int index, char[] str, int offset, int len)
	 */
	static void m() {
		StringBuilder sb = new StringBuilder().append(ca);

		sb.insert(sb.length(), ca, 5, 2); // 0..956;
		System.out.println(sb);

		/*
		 * StringBuilder append(char[] c, int index, int len)
		 * 
		 * String.valueOf(char[] c, int index, int len)
		 */
	}

	static void m2() {
		StringBuilder sb = new StringBuilder();

		sb.insert(5, ca, 5, 2); // StringIndexOutOfBoundsException
		System.out.println(sb);
	}

	/*
	 * StringBuilder insert(int dstOffset, CharSequence s, int start, int end)
	 * 
	 * StringBuilder append(CharSequence s, int startIndex, int endIndex)
	 * 
	 * String substring(int startIndex, int endIndex)
	 */
	static void m3() {
		StringBuilder s = new StringBuilder(String.valueOf(ca));

		StringBuilder sb = new StringBuilder(s);
		sb.insert(5, s, 5, 7); // 0-4565-9
		System.out.println(sb);
	}

	static void m4() {
		StringBuilder source = new StringBuilder("ABCDEFGHIJ");
		StringBuilder sb = new StringBuilder(String.valueOf(ca));
		sb.insert(5, source, 5, 7); // 0..4FG5..9
		System.out.println(sb);
	}

	public static void main(String[] args) {
		// m();
		// m3();
		// m4();
		m4();
	}
}
