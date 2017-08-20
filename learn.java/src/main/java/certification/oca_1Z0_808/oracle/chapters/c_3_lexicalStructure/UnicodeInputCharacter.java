package oracle.chapters.c_3_lexicalStructure;

public class UnicodeInputCharacter {

	class UnicodeEscape{
		/*
		 * "\" u hexDigit hexDigit hexDigit hexDigit
		 */
	}
	
	class RawInputCharacter{
		/*
		 * any Unicode character
		 */
	}
	
	static void m(){
		String s = "\u2122";
		System.out.println("s: " + s);
//		System.out.println("s: " + Integer.parseInt(s));
	}
	
	static void rawInput(){
		String s = "\\u2122=\u2122";
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		m();
		rawInput();
	}
}
