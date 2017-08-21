package oc.a.chapters.c6_exceptions.understandingExceptions.unchecked;

/**
 * Error means something went so horribly wrong that your program should not
 * attempt to recover from it. For example, the disk drive �disappeared.�
 * 
 * 
 * Okay for the program to catch: No
 * 
 * Is program required to handle or declare: No
 */
public class OwnError extends Error {

	public OwnError(String message) {
		super(message);
	}

}
