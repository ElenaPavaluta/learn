package books.thinkigInJava._4ThEdition.chapters.generics.anonymousInnerClasses;

class Teller {
    static long counter = 1;
    private final long id = counter++;

    private Teller() {
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + id;
    }

    static Generator<Teller> generator(){
        return ()->new Teller();
    }
}
