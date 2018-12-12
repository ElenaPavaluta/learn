package i.nespresso.tournament;

class Weapon {

    void hit(final Warrior enemy) {
        enemy.receiveHit(this);
    }
}
