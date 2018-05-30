package oc.a.chapters._3_core_java_apis.stringBuilderClass.importantStringBuilderMethods;

public class Test {

	static void m(){
		StringBuilder sb = new StringBuilder("animals");
		String sub = sb.substring(sb.indexOf("a"), sb.indexOf("al"));  //anim
		int len = sb.length();  //7
		char ch = sb.charAt(6);  //s
		System.out.println(sub + " " + len + " " + ch);
	}
		
	
	public static void main(String[] args) {
		m();
	}
}
