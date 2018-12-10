package interview.nespresso._2;

import jersey.repackaged.jsr166e.extra.AtomicDouble;

class Cannon {
    static final int UNITARY_LIFE = 100;
    static final double FIRE_POWER = 200;
    private AtomicDouble life = new AtomicDouble(UNITARY_LIFE);
}
