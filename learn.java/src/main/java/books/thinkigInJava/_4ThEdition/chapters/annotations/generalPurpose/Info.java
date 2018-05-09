package books.thinkigInJava._4ThEdition.chapters.annotations.generalPurpose;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * 
 * 
 * @Override, to indicate that a method definition is intended to override a
 * method in the base class. This generates a compiler error if you accidentally
 * misspell the method dishName or give an improper signature.2
 * 
 * 
 * @Deprecated, to produce a compiler warning if this element is used.
 * 
 * 
 * @SuppressWarnings, to turn off inappropriate compiler warnings. This
 * annotation
 *
 */
class Info {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Deprecated
	void m(){
		ArrayList a = new ArrayList<>();
		a.add(LocalDateTime.now());
		System.out.println(a.get(0));
	}
	
}
