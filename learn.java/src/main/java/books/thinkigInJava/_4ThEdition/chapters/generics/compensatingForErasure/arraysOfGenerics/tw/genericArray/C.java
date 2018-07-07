package books.thinkigInJava._4ThEdition.chapters.generics.compensatingForErasure.arraysOfGenerics.tw.genericArray;

import java.time.LocalDate;

class C<T> {

    A<T>[] atArr;
    T[] tArr;

    void m2(){
        System.out.println(atArr instanceof Object);  //null instaceof Object: false
    }


    void m3(){
        /**
         * ClassCastException
         * Object cannot be cast to C.A
         *
         * new Object[10]:  creates an array of Objects: compiler error,
         * although at runtime A[T] is erased and replaced with Object
         *
         * In order to make the compiler happy the (A<T>[]) cast is required
         * which at runtime generates ClassCastException
         *
         *
         */
        atArr = (A<T>[]) new Object[10];
    }

    class A<U>{
    }

    void m4(){
        /**
         * The only way to create a generic array
         *
         * Arrays keep track of their actual dbType
         * which is established at runtime
         *
         * So, at runtime due to dbType erasure tArr  = new Object[10]
         * but at this point the compiler isn't happy.
         * In order to make the compiler happy the (T[]) cast
         * is required
         */
        tArr = (T[])new Object[10];

        System.out.println(tArr instanceof Object);  //true
        System.out.println(tArr instanceof Object[]);  //true
//        System.out.println(tArr instanceof T[]);  //compiler error: can't instanceof generic dbType
    }

    void m(){
        C<LocalDate>.A<StringBuilder> ca = new C<LocalDate>(). new A<StringBuilder>();

        C<T>.A<T> cat = new A<>();

    }

    public static void main(String[] args) {
        C<String> c = new C<>();
//        c.m2();
//        c.m3();
        c.m4();
    }
}
