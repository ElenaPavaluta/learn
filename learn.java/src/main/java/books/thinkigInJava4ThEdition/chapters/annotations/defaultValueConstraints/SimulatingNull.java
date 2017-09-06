package books.thinkigInJava4ThEdition.chapters.annotations.defaultValueConstraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * No element can have an unspecified value. This means that elements must
 * either have defaulT values or values provided by the class that uses the
 * annotation.
 * 
 *
 */


@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.CLASS)
@interface SimulatingNull {
	
	int id() default -1;
	String description() default "";

}
