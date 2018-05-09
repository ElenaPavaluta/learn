package books.thinkigInJava._4ThEdition.chapters.generics.bounds.battle;

class SuperHero<POWER extends SuperPower> {
    POWER power;

    public SuperHero(POWER power) {
        this.power = power;
    }

    public POWER getPower() {
        return power;
    }
}
