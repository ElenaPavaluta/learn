package books.thinkigInJava4ThEdition.chapters.annotations.generatingExternalFiles;

@interface Uniqueness {

	Constraints constraints() default @Constraints(unique = true);
}
