package books.thinkigInJava._4ThEdition.chapters.annotations.generatingExternalFiles;

@interface Uniqueness {

	Constraints constraints() default @Constraints(unique = true);
}
