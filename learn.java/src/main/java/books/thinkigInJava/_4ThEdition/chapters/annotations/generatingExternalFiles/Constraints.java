package books.thinkigInJava._4ThEdition.chapters.annotations.generatingExternalFiles;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {

	boolean primaryKey() default false;
	boolean allowNull() default true;
	boolean unique() default false;
}
