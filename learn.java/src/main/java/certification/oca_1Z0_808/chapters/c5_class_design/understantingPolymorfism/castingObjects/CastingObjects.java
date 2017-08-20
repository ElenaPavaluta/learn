package chapters.c5_class_design.understantingPolymorfism.castingObjects;

/**
 * 1. Casting an object from a subclass to a superclass doesn’t require an
 * explicit cast.
 * 
 * 2. Casting an object from a superclass to a subclass requires an explicit
 * cast.
 * 
 * 3. The compiler will not allow casts to unrelated types.
 * 
 * 4. Even when the code compiles without issue, an exception may be thrown at
 * runtime if the object being cast is not actually an instance of that class.
 *
 */
public class CastingObjects {


	static void m(){
		SubClass  s = new SubClass();
		SuperClass sc = s;
	}
	
	static void m2(){
		SuperClass parent = new SuperClass();
		SubClass child = (SubClass) parent;
		child.mInSubClass();  //throws class CastException
	}
	
	static void m3(){
		SubClass s = new SubClass();
//		LocalDate ls = s;  //compiler error: unrelated data types
	}
	
	public static void main(String[] args) {
		m();
		m2();
		m3();
	}
}
