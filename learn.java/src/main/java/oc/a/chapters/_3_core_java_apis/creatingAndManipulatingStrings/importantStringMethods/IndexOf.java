package oc.a.chapters._3_core_java_apis.creatingAndManipulatingStrings.importantStringMethods;

/**
 * 
 * int indexOf(int ch): returns the first occurrence of the char ch, or -1 if not found
 * 
 * indexOf(int ch, int fromIndex): returns the first occurrence of char ch starting from index
 * 
 * indexOf(String str): Returns the index within this string of the first occurrence of the specified substring
 *
 * indexOf(String str, int fromIndex): Returns the index within this string of the first occurrence 
 * 										of the specified substring, starting at the specified index.
 */
public class IndexOf {

	static String s = "logitech";
	static String s2 = "logitech logitech";
	
	static void indexOf(){
		System.out.println(s.indexOf('i'));  //3 
		System.out.println(s.indexOf('\u00ff'));  //-1
	}
	
	static void indexOf2(){
		System.out.println(s2.indexOf('i', 8));  //12
		System.out.println(s2.indexOf('i', 12));  //12
	}
	
	
	static void indexOf3(){
		System.out.println(s.indexOf("gi"));  //2
		System.out.println(s.indexOf("ig"));  //-1
 	}
	
	static void indexOf4(){
		System.out.println(s2.indexOf("gi", 8));  //11
		System.out.println(s2.indexOf("gi", 11));  //11
	}
	
	public static void main(String[] args) {
//		indexOf();
//		indexOf2();
//		indexOf3();
		indexOf4();
	}
}
