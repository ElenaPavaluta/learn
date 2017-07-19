package books.thinkigInJava4ThEdition.chapters.annotations.metaAnnotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // where this annotation can be applied
@Retention(RetentionPolicy.RUNTIME) // how long the annotation information is
									// kept
@Documented // include this annotations in the javadcos
@Inherited // allow subclasses to inherit parent annotations
@interface Meta {

}
