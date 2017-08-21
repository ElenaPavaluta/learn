package oc.a.chapters.c3_core_java_apis.stringBuilderClass.importantStringBuilderMethods;

import utils.constants.StringLiteralPool;

public class CharAt {

	static void charAt(){
		StringBuilder sb = new StringBuilder(StringLiteralPool.logitech);
		
		System.out.println(sb.length());  //8
		
		System.out.println(sb.charAt(6)); //c
		System.out.println(sb.charAt(8));  //StringIndexOutOfBondsException
	}
	
	static void charAt2(){
		StringBuilder sb = new StringBuilder();
		System.out.println(sb.capacity());  //16
		
		sb.append(StringLiteralPool.logitech);
		System.out.println(sb.charAt(6));  //c
		System.out.println(sb.charAt(8));  //StringIndexoutOfBondsException
 	}
	
	public static void main(String[] args) {
//		charAt();
//		charAt2();
	}
}
