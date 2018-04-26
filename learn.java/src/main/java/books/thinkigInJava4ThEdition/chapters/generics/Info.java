package books.thinkigInJava4ThEdition.chapters.generics;

/**
 * Because erasure removes type information in the body of a method,
 * what matters at run time is the boundaries:
 * the points where objects enter and leave a method.
 * These are the points at which the compiler performs type checks at compile time,
 * and inserts casting code.
 *
 * Erasure loses the ability to perform certain operations in generic code.
 * Anything that requires the knowledge of the exact type at run time won’t work.
 */
