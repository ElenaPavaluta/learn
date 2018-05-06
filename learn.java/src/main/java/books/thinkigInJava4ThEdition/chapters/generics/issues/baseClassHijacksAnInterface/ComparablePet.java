package books.thinkigInJava4ThEdition.chapters.generics.issues.baseClassHijacksAnInterface;

class ComparablePet implements Comparable<ComparablePet> {
    @Override
    public int compareTo(ComparablePet o) {
        return 0;
    }
}
