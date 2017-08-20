package chapters.c3_core_java_apis.stringBuilderClass.importantStringBuilderMethods;

import utils.constants.StringLiteralPool;

/**
 * int indexOf(String str)
 * 
 * 
 * int indexOf(String str, int fromIndex)
 *
 */
public class IndexOf {

	static void indexOf(){
		StringBuilder sb = new StringBuilder(StringLiteralPool.logitech);
		
		System.out.println(sb.indexOf("l"));  //0
		System.out.println(sb.indexOf(""));  //0
		System.out.println(sb.indexOf(" "));  //-1
		System.out.println(sb.indexOf(Integer.toString(Integer.MAX_VALUE)));  //-1;
		
		System.out.println("lenght: " + sb.length());
		System.out.println("capacity: " + sb.capacity());
	
		
		sb.append(" ").append(StringLiteralPool.logitech);
		
		System.out.println(sb.indexOf("l", 9)); //9
	}
	
	
	
	
	public static void main(String[] args) {
		indexOf();
	}
}
