package interview.nespresso._2;

import jersey.repackaged.jsr166e.extra.AtomicDouble;

class Hull {
    private long displacement;
    private AtomicDouble life;

    Hull(final long displacement) {
        this.displacement = displacement;
        this.life = new AtomicDouble(displacement);
    }
}
