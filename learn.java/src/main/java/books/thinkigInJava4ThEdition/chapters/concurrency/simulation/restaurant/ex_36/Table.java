package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant.ex_36;

class Table {

    private static int counter = 0;
    private final int tableNb = counter++;
    private final int capacity;

    public Table(int capacity) {
        this.capacity = capacity;
    }

    public int nb() {
        return tableNb;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ", id: " + tableNb;
    }

    public int capacity() {
        return capacity;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Table)) {
            return false;
        }
        Table t = (Table) obj;
        return this.tableNb == t.tableNb;
    }
}
