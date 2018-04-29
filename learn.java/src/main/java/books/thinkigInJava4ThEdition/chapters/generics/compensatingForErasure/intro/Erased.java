package books.thinkigInJava4ThEdition.chapters.generics.compensatingForErasure.intro;

import java.time.LocalDate;
import java.util.Locale;

/**
 * Erasure loses the ability to perform certain operations in generic code.
 * Anything that requires the knowledge of the exact type at run time won’t work
 */
class Erased<T> {

    private static final int SIZE = 100;

    static void f(Object arg){
        /**
         * T at runtime is replaced with Object,
         * so arg instanceof T will always return true
         */
//        if (arg instanceof T){}  //compiler error

        /**
         *T may not contain a non param constructor
         *  - a good example of a need to know the exact type
         */
//        T var = new T();  //compiler error

        /**
         *
         */
//        T[] array = new T[SIZE];  //compiler error
    }

    static void f2(){
        Locale[]  arr = new Locale[3];
        arr[0] = Locale.US;
        arr[1] = Locale.CANADA;
        arr[2] = Locale.CHINA;

//        arr[0] = (Locale) LocalDate.now();  //compiler error

        Object[] objects = arr;  //the exact contained type is know at runtime

        /**
         * This cast doesn't raise a compiler error,
         * but at runtime the jvm knows the exact type
         * of the array and throws a ClassCastException
         */
        LocalDate[] localDates = (LocalDate[])objects;

    }


    public static void main(String[] args) {
        f2();
    }
}
