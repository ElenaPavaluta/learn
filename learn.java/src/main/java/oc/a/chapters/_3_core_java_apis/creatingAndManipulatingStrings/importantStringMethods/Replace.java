package oc.a.chapters._3_core_java_apis.creatingAndManipulatingStrings.importantStringMethods;

import java.nio.CharBuffer;

import javax.swing.text.Segment;

/**
 * 
 * String replace(char oldChar, char newChar)
 * 
 * String replace(CharSequence oldChar, CharSequence newChar)
 *
 */
public class Replace {

	static String s = "logitech";
	static String oldCS = "logi";
	static String newCS = "LOGI";
	
	//CharSequence implementing classes
	static Segment segment = new Segment(new char[]{'L','O', 'G', 'I'}, 0, 4);
	static CharBuffer charBuffer; //abstract class
	static StringBuffer stringBuffer = new StringBuffer(oldCS);
	static StringBuilder stringBuilder = new StringBuilder(oldCS);
	static String string = new String(oldCS);
	
	
	static void replace(){
		String ns = s.replace('l', 'L');
		System.out.println(ns);  //Logitech
	}
	
	static void replace2(){
		String ns;
		ns = s.replace(oldCS, segment);
		System.out.println(ns);  //LOGItech
		
		ns = s.replace(oldCS, stringBuffer);
		System.out.println(ns); //logitech
		
		ns  =s.replace(stringBuilder, newCS);
		System.out.println(ns);  //LOGItech
		
		ns = s.replace(oldCS, newCS);
		System.out.println(ns);  //LOGItech
	}
	
	static void replace3(){
		String ns;
		ns = s.replace("aaa", "bbb");
		System.out.println(ns);
	}
	
	
	public static void main(String[] args) {
//		replace();
//		replace2();
		replace3();
	}
}
