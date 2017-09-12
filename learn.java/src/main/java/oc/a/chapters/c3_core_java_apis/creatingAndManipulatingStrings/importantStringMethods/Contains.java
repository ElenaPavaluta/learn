package oc.a.chapters.c3_core_java_apis.creatingAndManipulatingStrings.importantStringMethods;

import java.nio.CharBuffer;

import javax.swing.text.Segment;

/**
 * boolean contentEquals(CharSequence chapters):
 * 
 * Returns true if and only if this string contains the specified sequence of
 * char values.
 * 
 */

public class Contains {
	static String s = "logitech";
	static String ss = "logitech logitech";
	
	//CharSequence implementing classes
	static Segment segment = new Segment(new char[]{'l','o', 'g', 'i'}, 0, 3);
	static CharBuffer charBuffer; //abstract class
	static StringBuffer stringBuffer = new StringBuffer("logi");
	static StringBuilder stringBuilder = new StringBuilder("logi");
	static String string = new String("logi");
	
	
	static void contains(){
		System.out.println(s.contains(segment));  //true;
		System.out.println(s.contains(stringBuffer));  //true;
		System.out.println(s.contains(stringBuilder));  //true;
		System.out.println(s.contains(string));  //true
	}
	
	
	static void m(){
		String s = "this is a trial String";
//		System.out.println(s.contains('h'));  //compilation error
	}
	
	public static void main(String[] args) {
		contains();
	}
	

}



