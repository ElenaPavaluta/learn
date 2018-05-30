package oc.a.chapters._6_exceptions.understandingExceptions.unchecked;

/**
 * A runtime exception: RuntimeException class and its subclasses (accessing an
 * invalid array index).
 * 
 * Okay for the program to catch: Yes
 *
 * Is program required to handle or declare: No
 * 
 * A runtime (unchecked) exception is a specific type of exception. All
 * exceptions occur at the time that the program is run. (The alternative is
 * compile time, which would be a compiler error.) People don�t refer to them as
 * run time exceptions because that would be too easy to confuse with runtime!
 * When you see runtime, it means unchecked.
 */
public class OwnRuntimeException extends RuntimeException {

	public OwnRuntimeException(String message) {
		super(message);
	}

}
