package oc.p.chapters.c_6_ExceptionsAndAssertions.usingTryWithResources.tryWithResourcesBasics;

import java.io.IOException;

/**
 * The resources created in the try with resources clause are
 * only in scope within the try block.
 *
 * The implicit finally runs before any catch/finally blocks
 *
 */
class Basics {

    public static void main(String[] args) {
        Basics b = new Basics();
        b.m();
    }

    void m() {
        try(C c = new C()) {
            c.m();
        } catch(IOException e) {
            System.out.println("cath block run");
        } finally {
            System.out.println("finally bllock run");
        }
    }

    class C implements AutoCloseable {

        C() {
            System.out.println("C constructor run");
        }

        void m() throws IOException {
            System.out.println("C m() run");
            throw new IOException();
        }

        @Override
        public void close() {
            System.out.println("C close run");
        }
    }
}
