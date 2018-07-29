package oc.p.chapters._6_ExceptionsAndAssertions.usingTryWithResources.tw._2;

import java.util.Arrays;

class Se {

    static void m(){
        Se se = new Se();
        try(A a = se.new A();
        B b = se.new B();
        C c = se.new C()) {
            a.m();
            b.m();
            c.m();
        } catch(Exception e) {
            System.out.println("caught: " + e.getMessage());
            Arrays.stream(e.getSuppressed()).forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        m();
    }

    interface I extends AutoCloseable{
        void m() throws Exception;
    }

    class A implements I{
        @Override
        public void m() throws Exception {
            throw new Exception("A m()");
        }

        @Override
        public void close() throws Exception {
            throw new Exception("A close()");
        }
    }

    class B implements I{
        @Override
        public void m() throws Exception {
            throw new Exception("B m()");
        }

        @Override
        public void close() throws Exception {
            throw new Exception("B close()");
        }
    }

    class C implements I{
        @Override
        public void m() throws Exception {
            throw new Exception("C m()");
        }

        @Override
        public void close() throws Exception {
            throw new Exception("C close()");
        }
    }
}
