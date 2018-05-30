package oc.a.chapters._3_core_java_apis.stringBuilderClass.importantStringBuilderMethods;

import utils.constants.Pool;

/**
 * StringBuilder delete(int start, int end)
 *
 */
public class Delete {

	static void m(){
		StringBuilder sb = new StringBuilder(String.valueOf(Pool.charArray0_9, 0, Pool.charArray0_9.length));
		
		sb.delete(1, 9);
		System.out.println(sb); //09
	}
	
	
	public static void main(String[] args) {
		m();
	}
}
