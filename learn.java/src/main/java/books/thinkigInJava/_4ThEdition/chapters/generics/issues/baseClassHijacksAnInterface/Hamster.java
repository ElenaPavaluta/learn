package books.thinkigInJava._4ThEdition.chapters.generics.issues.baseClassHijacksAnInterface;

class Hamster extends ComparablePet implements Comparable<ComparablePet> {

    @Override
    public int compareTo(ComparablePet o) {
        return super.compareTo(o);
    }
}
