package oc.a.chapters._3_core_java_apis.stringBuilderClass.importantStringBuilderMethods.wrk;

import java.net.HttpCookie;
import java.time.LocalDateTime;

class Equals {

	static StringBuilder sb = new StringBuilder("A trial StringBuilder");
	
	
	static void m(){
		System.out.println(sb.equals(new StringBuilder()));  //false
	}
	
	static void m2(){
		System.out.println(sb.equals(LocalDateTime.now()));  //false
	}
	
	
	static void m3(){
		System.out.println(sb.equals(null));  //false
	}
	
	static void m4(){
		HttpCookie o = new HttpCookie("a", "a");
		System.out.println(sb.equals(o));  //false
	}
	
	public static void main(String[] args) {
		m();
		m2();
		m3();
		m4();
	}
	
}
