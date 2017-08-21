package oc.a.chapters.c6_exceptions.usingATryStatement.addingAFinallyBlock;

public class Syntax {

	/*
	 * Compiler error due to wrong order
	 */
	static void m() {
		// try {
		// throw new CheckedException();
		//
		// }finally {
		//
		// } catch (CheckedException e) {
		//
		// }
	}
	
	static void m2(){
		String s = "";
		try {
			s += "t";
		} catch (Exception e) {
			s+="c";
		}finally {
			s += "f";
		}
		
		s+= "a";
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		m2();  //tfa
	}
}
