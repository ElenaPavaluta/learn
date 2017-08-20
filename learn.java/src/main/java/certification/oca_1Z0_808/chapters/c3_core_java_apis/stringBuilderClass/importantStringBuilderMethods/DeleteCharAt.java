package chapters.c3_core_java_apis.stringBuilderClass.importantStringBuilderMethods;

import java.util.Date;

import utils.constants.Pool;

/**
 * StringBuilder deleteCharAt(int index)
 *
 */
public class DeleteCharAt {

	static void m(){
		StringBuilder sb = new StringBuilder(new Date().toString());
		System.out.println(sb);
		sb.deleteCharAt(0);
		System.out.println(sb);
	}
	
	static void m2(){
		StringBuilder sb = new StringBuilder(String.valueOf(Pool.charArray0_9));
		sb.deleteCharAt(11);  //StringIndexOutOfBoundsException
	}
	
	public static void main(String[] args) {
		m();
		m2();
	}
}
