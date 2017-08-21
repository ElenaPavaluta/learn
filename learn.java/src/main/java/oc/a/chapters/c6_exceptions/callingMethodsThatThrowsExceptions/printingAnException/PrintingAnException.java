package chapters.c6_exceptions.callingMethodsThatThrowsExceptions.printingAnException;

import utils.delimitators.Delimitators;

public class PrintingAnException {

	static void hop(){
		throw new RuntimeException("can not hop");
	}

	static void m(){
		try {
			hop();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	static void m2(){
		try {
			hop();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	static void m3(){
		try {
			hop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		m();
		Delimitators.equal();
		m2();
		Delimitators.equal();
		m3();
	}
}
