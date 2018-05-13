package books.thinkigInJava._4ThEdition.chapters.generics.exceptions;

/**
 * Because of erasure, the use of generics with exceptions
 * is extremely limited. A catch clause cannot catch an exception
 * of a generic type, because the exact type of the exception
 * must be known at both compile time and run time.
 * Also, a generic class can’t directly or indirectly
 * inherit from Throwable (this further prevents you from
 * trying to define generic exceptions that can’t be caught)
 */
class Info {
}
