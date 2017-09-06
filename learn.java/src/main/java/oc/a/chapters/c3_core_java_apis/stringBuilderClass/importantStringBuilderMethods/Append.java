package oc.a.chapters.c3_core_java_apis.stringBuilderClass.importantStringBuilderMethods;

import java.util.Date;
import java.util.HashSet;

import javax.swing.text.Segment;

public class Append {

	static char[] ca = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	static void m() {
		StringBuilder sb = new StringBuilder();
		int offset = 2;
		int len = ca.length - offset;
		sb.append(ca, offset, len); // sb = 2...9

		System.out.println(sb.toString());
	}

	static void m2() {
		CharSequence cs = new Segment();
		cs = new String();
		cs = new StringBuffer();

		cs = new StringBuilder().append(ca, 0, ca.length);

		StringBuilder sb = new StringBuilder();
		sb.append(cs);

		System.out.println(sb);
	}

	static void m3() {
		CharSequence cs = new StringBuilder(String.valueOf(ca, 0, ca.length));

		StringBuilder sb = new StringBuilder();

		sb.append(cs, 3, 5); // sb = 34
		System.out.println(sb);
	}

	static void m4() {
		StringBuilder s = new StringBuilder(String.valueOf(ca, 0, ca.length));

		StringBuilder sb = new StringBuilder();

		sb.append(s, 3, 26); // IndexOutOfBoundsException
		System.out.println(sb);
	}

	static void m5() {
		Date d = new Date();
		StringBuilder sb = new StringBuilder();
		sb.append(d);

		System.out.println(sb);
	}

	static void m6() {
		/*
		 * StringBuilder append(char[] ca, int index/offset, int len/count )
		 * 
		 * String.valueOf(char[] ca, int index/offset, int len/count)
		 */
		StringBuilder sb = new StringBuilder();
		sb = sb.append(ca, 5, 2); // sb = 56
		System.out.println(sb);
	}

	static void m7() {
		/*
		 * StringBuilder append(CharSequence cs, int startIndex, int endIndex)
		 * 
		 * String substring(String source, int startIndex, int endIndex)
		 */
		StringBuilder cs = new StringBuilder(String.valueOf(ca, 0, ca.length));

		StringBuilder sb = new StringBuilder();
		sb.append(cs, 5, 7); // sb = 56

		System.out.println(sb);
	}

	static void m8() {
		StringBuilder sb = new StringBuilder();
		sb.append(new HashSet<String>());
		System.out.println(sb);
	}

	public static void main(String[] args) {
		// m();
		// m3();
		// m4();
		// m4();
		// m5();
		// m6();
		// m7();
		m8();
	}
}
