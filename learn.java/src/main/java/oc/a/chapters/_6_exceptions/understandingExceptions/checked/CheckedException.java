package oc.a.chapters._6_exceptions.understandingExceptions.checked;

/**
 * A checked exception: Exception and all subclasses that do not extend
 * RuntimeException.
 * 
 * Okay for the program to catch: Yes
 * Is program required to handle or declare: Yes
 * 
 * 
 *
 */
public class CheckedException extends Exception {

	
	
	public CheckedException() {
		super();
	}

	public CheckedException(String message) {
		super(message);
	}

}
