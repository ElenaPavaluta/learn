package i.nespresso.naval.battle;

import java.util.Comparator;

import static java.util.Comparator.comparingDouble;

class Ship {
    static final int MAST_UNITARY_LIFE = 1000;
    static final int CANNON_UNITARY_LIFE = 100;
    static final double CANNON_FIRE_POWER = 200;
    static Comparator <Ship> COMPARE_BY_SPEED = comparingDouble(Ship::speedPenalty);

    private double life = 0;
    private double firePower = 0;

    private String name;
    private int displacement;
    private int masts;
    private int cannons;

    Ship(final String name, final int displacement, final int masts) {
        this(name, displacement, masts, 0);
    }

    Ship(final String name, final int displacement, final int masts, final int cannons) {
        this.name = name;
        this.displacement = displacement;
        this.masts = masts;
        this.cannons = cannons;
        life = displacement + masts * MAST_UNITARY_LIFE + cannons * CANNON_UNITARY_LIFE;
        firePower = defaultFirePower();
    }

    private double defaultFirePower() {
        return cannons * CANNON_FIRE_POWER;
    }

    synchronized void addFireBonus(final double fireBonus) {
        final double power = defaultFirePower();
        firePower = power + power * fireBonus;
    }

    synchronized boolean isActive() {
        return life > 0;
    }

    synchronized boolean isDistroyed() {
        return life <= 0;
    }

    void fireTo(final Ship target) {
        if (isActive()) {
            System.out.println(name + " -> fireTo(" + firePower + ") -> " + target.name);
            target.sufferDamage(firePower);
        }
    }

    private synchronized void sufferDamage(final double firePower) {
        if(isActive()){
            life -= firePower;
        }
    }

    double speedPenalty() {
        final int penalty = displacement / masts;
        return penalty + 0.5 / 100 * cannons * penalty;
    }

    boolean isEqualTo(final Ship ship) {
        return this.displacement == ship.displacement && this.masts == ship.masts && this.cannons == ship.cannons;
    }
}
