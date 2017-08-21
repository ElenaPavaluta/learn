package chapters.c3_core_java_apis.creatingAndManipulatingStrings;

/**
 * The string pool, also known as the intern pool, is a location in the Java
 * virtual machine (JVM) that collects all these strings.
 *
 */
public class TheStringPool {

	String name = "fluffy";  //uses the String pool normally
	String name2 = new String("fluffy"); // doesn't uses the String pool
											// normally; it created a new object
											// (even if it's less efficient)	
	
}
