package books.thinkigInJava._4ThEdition.chapters.generics.issues.baseClassHijacksAnInterface;

class Dog extends ComparablePet {

    @Override
    public int compareTo(ComparablePet o) {
        return super.compareTo(o);
    }
}
