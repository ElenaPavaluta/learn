package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers.ex.ex_26;

class Table {

    private final int tableNb;

    public Table(int tableNb) {
        this.tableNb = tableNb;
    }

    @Override
    public String toString() {
        return "Table{" +
                "nb=" + tableNb +
                '}';
    }
}
