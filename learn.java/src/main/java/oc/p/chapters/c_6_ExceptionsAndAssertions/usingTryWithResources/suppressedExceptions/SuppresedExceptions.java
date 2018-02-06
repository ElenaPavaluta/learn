package oc.p.chapters.c_6_ExceptionsAndAssertions.usingTryWithResources.suppressedExceptions;

import java.util.Arrays;

/**
 * The suppressed exceptions apply only to exceptions thrown in the try clause
 */
class SuppresedExceptions {

    class JamedTurkeyCage implements AutoCloseable{

        @Override
        public void close() throws IllegalStateException {
            throw new IllegalStateException("Cage door does not close");
        }
    }

    void m(){
        try (JamedTurkeyCage t = new JamedTurkeyCage()){
            System.out.println("put turkey in");
        }catch(IllegalStateException e){
            System.out.println("caught: " + e.getMessage());
        }
    }

    void m2(){
        try(JamedTurkeyCage t = new JamedTurkeyCage()){
            throw new IllegalStateException("turkeys run off");
        }catch(IllegalStateException e){
            System.out.println("caught: " + e.getMessage());
            Arrays.asList(e.getSuppressed())
                    .stream()
                    .forEach(t-> System.out.println(t.getMessage()));
//
//              for(Throwable t: e.getSuppressed()){
//                System.out.println(t.getMessage());
//            }
        }
    }

    void m3(){
        try(JamedTurkeyCage t = new JamedTurkeyCage();
        JamedTurkeyCage t2 = new JamedTurkeyCage()) {
            System.out.println("turkeys entered cages");
        }catch(IllegalStateException e){
            System.out.println("caught: " + e.getMessage());
            Arrays.asList(e.getSuppressed())
                    .stream()
                    .forEach(t-> System.out.println(e.getMessage()));
        }
    }

    void m4(){
        try(JamedTurkeyCage t = new JamedTurkeyCage()){
            throw new IllegalStateException("turkeys run off");
        }finally {
            throw new RuntimeException("and we couldn't find them");
        }
    }

    public static void main(String[] args) {
        SuppresedExceptions se = new SuppresedExceptions();
//        se.m();
//        se.m2();
//        se.m3();
        se.m4();
    }
}
