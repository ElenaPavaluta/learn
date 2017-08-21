package oc.a.chapters.c3_core_java_apis.stringBuilderClass.importantStringBuilderMethods;

import java.util.Date;

public class Reverse {

	static void m(){
		StringBuilder sb = new StringBuilder(String.valueOf(new Date()));
		
		System.out.println(sb);
		
		sb.reverse();
		System.out.println(sb);
	}
	
	public static void main(String[] args) {
		m();
	}
}
