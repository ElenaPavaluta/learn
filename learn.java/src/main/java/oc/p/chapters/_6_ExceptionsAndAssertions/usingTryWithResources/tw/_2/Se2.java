package oc.p.chapters._6_ExceptionsAndAssertions.usingTryWithResources.tw._2;


import java.util.Arrays;

class Se2 {

    static void m(){
        Se2 se = new Se2();
        try(A a = se.new A();
            B b =se.new B();
            C c = se.new C()
        ) {
            a.m();
            b.m();
            c.m();
        } catch(Exception e) {
            System.out.println("Caught: " + e.getMessage());
            Arrays.stream(e.getSuppressed()).forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        //new A() throws an exception an the flow stops
        m();
    }

    abstract class Ac implements AutoCloseable{
        Ac() throws Exception {
            throw new Exception(getSimpleName() + " contr");
        }

        void m() throws Exception {
            throw new Exception(getSimpleName() + " m");
        }

        private String getSimpleName() {
            return this.getClass().getSimpleName();
        }

        @Override
        public void close() throws Exception {
            throw new Exception(getSimpleName() + " close");
        }
    }

    class A extends Ac{
        public A() throws Exception {
            super();
        }
    }

    class B extends Ac{
        public B() throws Exception {
            super();
        }
    }

    class C extends Ac{
        public C() throws Exception {
            super();
        }
    }
}
