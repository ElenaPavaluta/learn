package oc.p.tests.chapters._16.q._34;

import java.util.Arrays;

class MissedCallException extends Exception {
}

class Phone {

    static void makeCall() throws RuntimeException {
        throw new ArrayIndexOutOfBoundsException("call");
    }

    public static void main(String[] args) {
        try {
            m();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println();
            Arrays.stream(e.getSuppressed()).forEach(q -> System.out.println(q.getMessage()));
        }
    }

    public static void m() {
        try {
            makeCall();

//        }catch (MissedCallException e){

        } catch (RuntimeException e) {
            throw new RuntimeException("catch block");
        } finally {
            throw new RuntimeException("finally");
        }
    }
}
