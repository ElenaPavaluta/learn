package oc.a.chapters.c3_core_java_apis.creatingAndManipulatingStrings.importantStringMethods;

import java.net.HttpCookie;
import java.time.LocalDateTime;
import java.util.Comparator;

class Equals {

	static String s = "this is a String";

	static void m() {

		System.out.println(s.equals(new StringBuilder())); // false
	}

	static void m2(){
		System.out.println(s.equals(LocalDateTime.now()));  //false
	}
	
	static void m3(){
		System.out.println(s.equals(null));  //false
	}
	
	
	static void m4(){
		System.out.println(s.equals(new Comparator<HttpCookie>() {  // false

			@Override
			public int compare(HttpCookie o1, HttpCookie o2) {
				return 0;
			}
		}));
	}
	public static void main(String[] args) {
		m();
		m2();
		m3();
		m4();
	}
}
