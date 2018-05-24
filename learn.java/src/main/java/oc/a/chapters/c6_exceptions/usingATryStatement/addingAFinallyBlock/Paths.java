package oc.a.chapters.c6_exceptions.usingATryStatement.addingAFinallyBlock;

import oc.a.chapters.c6_exceptions.understandingExceptions.checked.CheckedException;
import utils.delimitators.Delimitators;

class Paths {

	static void path(boolean runCatch, boolean runSystemExist) {
		try {
			System.out.println("try");
			if (runCatch)
				throw new CheckedException("throw CheckedException");
		} catch (CheckedException e) {
			System.out.println("catch");
		} finally {
			if (runSystemExist)
				System.exit(0);
			else
				System.out.println("finally");
		}
	}

	public static void main(String[] args) {

		path(true, false); // try - catch - finally
		Delimitators.newLine();

		path(false, false); // try - finally
		Delimitators.newLine();
		
		path(true, true);  //try - catch  
	}
}
