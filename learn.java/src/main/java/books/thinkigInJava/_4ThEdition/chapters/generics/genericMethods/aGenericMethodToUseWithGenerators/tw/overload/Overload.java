package books.thinkigInJava._4ThEdition.chapters.generics.genericMethods.aGenericMethodToUseWithGenerators.tw.overload;

import java.util.Iterator;

class Overload {

    public static void main(String[] args) {
        Overload o = new Overload();
        o.call();
    }

    void m(A a) {
        a.a();
    }

    void m(AA a) {
        a.a();
    }

    void call() {
        m(new A());
        m(new AA());
        m(new AAA());
    }

    interface I<T> extends Iterator<T> {

    }

    class A {
        void a() {
            System.out.println(this.getClass().getSimpleName());
        }
    }

    class B implements Iterable {
        @Override
        public I iterator() throws RuntimeException {  //correct override
            return null;
        }
    }

    class AA extends A {
        @Override
        void a() {
            System.out.println("bla ");
            super.a();
        }
    }

    class AAA extends AA {

    }
}
