package oc.p.tests.chapters._16.q._36;

import java.io.FileNotFoundException;

class Piano {

    public static void main(String[] args) throws OutOfTuneException, FileNotFoundException {
        Piano p = new Piano();
        try {
            p.play();
        } catch (Exception e) {
            throw e;
        } finally {
            System.out.println("Song finished");
        }
    }

    void play() throws OutOfTuneException, FileNotFoundException {
        throw new OutOfTuneException("Sour note");
    }

    class OutOfTuneException extends Exception {
        OutOfTuneException(String msg) {
            super(msg);
        }
    }
}
