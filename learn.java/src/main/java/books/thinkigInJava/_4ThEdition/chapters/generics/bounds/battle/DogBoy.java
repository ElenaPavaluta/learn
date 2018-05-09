package books.thinkigInJava._4ThEdition.chapters.generics.bounds.battle;

class DogBoy extends CanineHero<SuperHearSmell> {
    public DogBoy() {
        super(new SuperHearSmell());
    }
}
