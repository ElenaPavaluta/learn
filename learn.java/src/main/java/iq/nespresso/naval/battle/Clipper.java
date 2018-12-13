package iq.nespresso.naval.battle;

class Clipper extends Ship {

    Clipper(final String name, final int displacement, final int masts) {
        super(name, displacement, masts);
    }

    Clipper(final String name, final int displacement, final int masts, final int cannons) {
        super(name, displacement, masts, cannons);
    }

    @Override
    double speedPenalty() {
        double penalty = super.speedPenalty();
        return penalty -= penalty * 20 / 100;
    }
}
