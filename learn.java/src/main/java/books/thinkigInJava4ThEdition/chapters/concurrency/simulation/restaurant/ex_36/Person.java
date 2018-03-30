package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant.ex_36;

class Person {

    private static int counter = 0;
    protected final int id = counter;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + id;
    }
}
