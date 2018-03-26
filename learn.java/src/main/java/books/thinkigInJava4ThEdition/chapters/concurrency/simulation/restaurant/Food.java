package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant;

class Food {

    private String item;

    public Food(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    @Override
    public String toString() {
        return item;
    }
}
