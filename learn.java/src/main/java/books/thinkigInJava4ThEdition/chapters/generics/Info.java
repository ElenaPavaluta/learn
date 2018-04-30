package books.thinkigInJava4ThEdition.chapters.generics;


/**
 * Because erasure removes type information in the body of a method,
 * what matters at run time is the boundaries:
 * the points where objects enter and leave a method.
 * These are the points at which the compiler performs type checks at compile time,
 * and inserts casting code.
 *
 * Erasure loses the ability to perform certain operations in generic code.
 *
 * ANYTHING THAT REQUIRES THE KNOWLEDGE OF THE EXACT TYPE AT
 * RUN TIME WON’T WORK.
 *
 * Because of erasure, the runtime type of an array (of generic) can only be Object[]
 */


class Info<T>{
    void m(){
        /**
         * Arrays keep track of their actual type, and that type is
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
