package books.thinkigInJava4ThEdition.chapters.generics.bounds.battle;

class CanineHero<POWER extends SuperHearing & SuperSmell> extends SuperHero<POWER> {
    public CanineHero(POWER power) {
        super(power);
    }

    void hear(){
        power.hearSubtleNoises();
    }

    void smell(){
        power.trackBySmell();
    }
}
