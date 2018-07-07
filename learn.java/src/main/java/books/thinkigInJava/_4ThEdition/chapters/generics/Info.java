package books.thinkigInJava._4ThEdition.chapters.generics;


/**
 * Because erasure removes dbType information in the body of a method,
 * what matters at run time is the boundaries:
 * the points where objects enter and leave a method.
 * These are the points at which the compiler performs dbType checks at compile time,
 * and inserts casting code.
 *
 * Erasure loses the ability to perform certain operations in generic code.
 *
 * ANYTHING THAT REQUIRES THE KNOWLEDGE OF THE EXACT TYPE AT
 * RUN TIME WON’T WORK.
 *
 * Because of erasure, the runtime dbType of an array (of generic) can only be Object[]
 *
 * Arrays are completely defined in the language and can thus have both
 * compile-time and run-time check built in.s
 *
 *
 * List actually means "a raw List that holds any Object dbType,
 * " whereas List<?> means "a non-raw List of some specific dbType,
 * but we just don’t know what that dbType is."
 *
 * A generic interface cannot be implemented twice in the same class hierarchy
 *
 * Self-bounding takes the extra step of forcing the generic
 * to be used as its own bound argument
 * class SelfBounded<T extends SelfBounded<T>>{}
 */


class Info<T>{
    void m(){
        /**
         * Arrays keep track of their actual dbType, and that dbType is
         * established at the point of creation of the array.
         *
         * THE ONLY WAY TO CREATE AN ARRAY OF GENERIC TYPE
         */
       T[] tArr = (T[])new Object[10];

      T t = null;

       tArr[0] =t;
//       tArr[1] = new Object();  //compiler error
    }
}
