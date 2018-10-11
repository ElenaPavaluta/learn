package oc.p.tests.chapters._12.q._31;

/**
 * Static interfaces methods can only be accessed using the interface,
 * not a class implementing that interfaces.
 */
interface Alex {
    static void publish() {
    }

    default void write() {
    }

    void think();
}

interface Michael {
    public static void publish() {
    }

    public default void write() {
    }

    public void think();
}

class Twins implements Alex, Michael {
    @Override
    public void write() {
    }

    @Override
    public void think() {

    }

    /*@Override*/
//    public static void publish(){}


    public static void main(String[] args) {
        Twins t = new Twins();
        Alex.publish();
        Michael.publish();
    }
}