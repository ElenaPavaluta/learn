package books.thinkigInJava4ThEdition.chapters.generics.genericInterfaces.coffe;

class Coffe {

    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
