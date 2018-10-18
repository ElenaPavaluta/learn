package oc.p.tests.chapters._16.q._40;

import utils.print.Print;

import java.util.Arrays;

final class FallenException extends Exception {
    FallenException(String message) {
        super(message);
    }
}

final class HikingGear implements AutoCloseable {
    @Override
    public void close() throws Exception {
        throw new FallenException("FE");
    }
}

class Cliff {

    public static void main(String[] args) {
        try {
            new Cliff().climb();
        } catch (Throwable t) {
            System.out.println(t.getMessage());
            Print.Delimitators.equal();
            Arrays.stream(t.getSuppressed()).forEach(e -> System.out.println(e.getMessage()));
        }
    }

    final void climb() throws Exception {
        try (HikingGear gear = new HikingGear()) {
            throw new RuntimeException("RE");
        }
    }
}
