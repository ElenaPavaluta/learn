package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant.ex_36;

class Person {

    protected int id;

    public Person(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + id;
    }
}
