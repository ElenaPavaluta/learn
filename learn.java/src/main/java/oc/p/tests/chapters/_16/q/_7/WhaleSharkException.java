package oc.p.tests.chapters._16.q._7;

class WhaleSharkException extends Exception {

    WhaleSharkException() {
        super("Frinedly");
    }

    WhaleSharkException(String message) {
        super(new Exception(new WhaleSharkException()));
    }

    WhaleSharkException(Exception cause) {
    }
}
