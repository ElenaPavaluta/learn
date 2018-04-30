package books.thinkigInJava4ThEdition.chapters.generics.compensatingForErasure.arraysOfGenerics;

import java.util.ArrayList;

class ArrayOfGeneric<T> {

    static final int SIZE = 100;
    static Generic<Integer>[] gia;
    T[] tArr;

    static void m(){
        /**
         * ClassCastException
         * Object cannot be cast to Generic;
         *
         *
         * Arrays keep track of their actual type, and that type is
         * established at the point of creation of the array.
         *
         * So even though gia has been cast to a Generic < Integer >[],
         * that information only exists at compile time
         * At run time, it’s still an array of Object,
         * and causes problem
         */
        gia = (Generic<Integer>[]) new Object[SIZE];

        /**
         * ClassCastException
         *
         * Object cannot be cast to Generic
         */
//        Generic<Object>[] arr = (Generic<Object>[]) new Object[SIZE];
    }


    void m2(){
        /**
         * THE ONLY WAY TO CREATE A ARRAY OF GENERIC TYPE
         */
        tArr = (T[])new Object[SIZE];
    }

    public static void main(String[] args) {
        m();
        new ArrayOfGeneric<String>().m2();
    }
}
