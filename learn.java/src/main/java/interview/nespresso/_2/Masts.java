package interview.nespresso._2;

import jersey.repackaged.jsr166e.extra.AtomicDouble;

class Masts {
    static final int UNITARY_LIFE = 1000;
    private int nbOfMasts;
    private AtomicDouble life;

    Masts(final int nbOfMasts) {
        this.nbOfMasts = nbOfMasts;
        life = new AtomicDouble(nbOfMasts * UNITARY_LIFE);
    }
}
