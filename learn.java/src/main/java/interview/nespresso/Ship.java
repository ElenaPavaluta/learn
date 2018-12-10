package interview.nespresso;

import java.util.Comparator;
import java.util.function.BiPredicate;

import static java.util.Comparator.comparingDouble;

class Ship {
    protected long displacement;
    protected int masts;
    protected int cannons;
    protected BiPredicate <Ship, Ship> HAS_SAME_CONSTRUCTIVE_CHARACTERISTICS = (a, b) -> a.displacement == b.displacement && a.masts == b.masts && a.cannons == b.cannons;
    protected double life;
    protected double speedPenalty;

    Comparator <Ship> COMPARE_BY_SPEED = comparingDouble(Ship::speedPenalty);

    Ship(final long displacement, final int masts) {
        this(displacement, masts, 0);
    }

    Ship(final long displacement, final int masts, final int cannons) {
        this.displacement = displacement;
        this.masts = masts;
        this.cannons = cannons;
        life = life();
        speedPenalty = speedPenalty();
    }

    private double speedPenalty() {
        double penalty = displacement / masts;
        return cannons != 0 ? penalty += 0.5 * cannons * penalty / 100 : penalty;
    }


    private long life() {
        return displacement + masts * 1000 + cannons * 100;
    }

    boolean floats() {
        return life > 0;
    }

    boolean isEqualTo(Ship ship) {
        return HAS_SAME_CONSTRUCTIVE_CHARACTERISTICS.test(this, ship);
    }
}
