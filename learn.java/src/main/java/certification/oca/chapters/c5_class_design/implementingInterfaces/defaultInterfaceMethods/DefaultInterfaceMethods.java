package chapters.c5_class_design.implementingInterfaces.defaultInterfaceMethods;

/**
 * 1. A default method may only be declared within an interface and not within a
 * class or abstract class.
 * 
 * 2. A default method must be marked with the default keyword. If a method is
 * marked as default, it must provide a method body.
 * 
 * 3 . A default method is not assumed to be static, final, or abstract, as it
 * may be used or overridden by a class that implements the interface.
 *
 * 4. Like all methods in an interface, a default method is assumed to be public
 * and will not compile if marked as private or protected.
 */
public interface DefaultInterfaceMethods {

	boolean hasScale(); // public abstract assumed

	public default double getTemp() {
		return 10f;
	}

	// public default void m(); //compiler error: a body must be provided

	default void m2() {  //public assumed
	}
	
//	protected default void m3(){}  //compiler error
	
//	private default void m4(){}  //compiler error
	
//	abstract default void m5(){}  //compiler error
	
//	final default void m6(){}  //compiler error
	
//	static default m7(){}  //compiler error
	
}
