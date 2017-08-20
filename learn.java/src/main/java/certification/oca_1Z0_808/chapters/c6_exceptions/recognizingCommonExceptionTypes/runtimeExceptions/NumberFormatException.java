package chapters.c6_exceptions.recognizingCommonExceptionTypes.runtimeExceptions;

public class NumberFormatException {

	static void m(){
		int a = Integer.parseInt("abc");
	}
	
	public static void main(String[] args) {
		m();
	}
}
