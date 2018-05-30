package oc.a.chapters._3_core_java_apis.stringBuilderClass.importantStringBuilderMethods.wrk;

class Insert {

	static StringBuilder sb = new StringBuilder("abcd");
	
	static void m(){
		sb.insert(0, "0123");
		System.out.println(sb);
	}
	
	public static void main(String[] args) {
		m();
	}
}

