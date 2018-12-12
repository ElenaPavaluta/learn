package i.nespresso.tournament;

import java.util.concurrent.ExecutorService;

class Warrior {
    protected int life;
    protected Weapon weapon;

    synchronized boolean isAlive() {
        return life > 0;
    }

    synchronized boolean isDead() {
        return life <= 0;
    }

    void engage(Warrior warrior) {
        new Fight(this, warrior);
    }

    void attack(final ExecutorService exec, final Warrior enemy) {
//        Runnable r = () -> hitOpponent(enemy);
        hitOpponent(enemy);
    }

    private void hitOpponent(final Warrior enemy) {
        weapon.hit(enemy);
    }

    void receiveHit(final Weapon weapon) {

    }
}
