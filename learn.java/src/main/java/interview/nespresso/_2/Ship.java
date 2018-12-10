package interview.nespresso._2;

class Ship {
    double life =  0;
    double firePower = 0;
    private Hull hull;
    private Masts masts;
    private Artillery artillery;

    Ship(final long displacement, final int masts) {
        this(displacement, masts, 0);
    }
    Ship(final long displacement, final int masts, final int cannons) {
        this.hull = new Hull(displacement);
        this.masts = new Masts(masts);
        this.artillery = new Artillery(cannons);
    }

    void addFireBonus(final double fireBonus) {
        return;
    }

    synchronized boolean isActive() {
        return life > 0;
    }

    synchronized boolean isDistroyed() {
        return life <= 0;
    }

    synchronized void fireTo(final Ship target) {
        if (isActive()) {
            target.sufferDamage(firePower);
        }
    }

    private synchronized void sufferDamage(final double firePower) {
    }

    synchronized Hull getHull() {
        return hull;
    }

    synchronized Masts getMasts() {
        return masts;
    }

    synchronized Artillery getArtillery() {
        return artillery;
    }
}
