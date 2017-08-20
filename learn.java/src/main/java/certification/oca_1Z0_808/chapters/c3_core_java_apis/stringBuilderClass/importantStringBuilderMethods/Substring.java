package chapters.c3_core_java_apis.stringBuilderClass.importantStringBuilderMethods;

import utils.constants.StringLiteralPool;

/**
 * String substring(int start)
 *
 * String substring(int start, int end)
 */
public class Substring {

	static StringBuilder sb = new StringBuilder().append(StringLiteralPool.logitech).append(" ").append(StringLiteralPool.logitech);
	
	static void substring(){
		String s;
		
		s = sb.substring(8);
		System.out.println("s: " + s);
		
		s =sb.substring(8, 9); //prints a while space
		System.out.println("s: " + s);
	}
	
	public static void main(String[] args) {
		substring();
	}
}
