package books.thinkigInJava._4ThEdition.chapters.generics.bounds.battle;

class SuperHearSmell implements SuperHearing, SuperSmell {
    @Override
    public void hearSubtleNoises() {
        System.out.println("hearSubtleNoises");
    }

    @Override
    public void trackBySmell() {
        System.out.println("trackNySmell");
    }
}
