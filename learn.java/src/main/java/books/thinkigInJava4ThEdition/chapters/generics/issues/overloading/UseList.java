package books.thinkigInJava4ThEdition.chapters.generics.issues.overloading;

import java.util.List;

/**
 * The solution is to change the name of the method
 */
class UseList<W, T> {

    void f(List<W> ws) {
    }

    /**
     * Compiler error
     *
     * Since instanceof list<W> == instanceof List<T>,
     * the compiler plays safe and raise an error.
     * By the way who could stop you to use the same type
     * for both W an T, like Use<String, String>
     */
//    void f(List<T> ts){};

    <W extends A, T extends B> void m(List<W> ws) {
    }

//    <W extends A, T extends B> void m(List<T> ts){}  //compiler error
}

class UseList2<W extends A, T extends B> {
    void m(List<W> ws) {
    }

//    void m(List<T> ts){} //compiler error, once again
}

class A {
}

class B {
}



