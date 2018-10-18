package oc.p.tests.chapters._16.q._37;

class Falcon extends Exception{

    private int parsec = 12;

    Falcon(String message) {
        super(message);
    }

    public static void main(String[] args) {
        assert new Falcon(null).parsec<12;
    }
}
