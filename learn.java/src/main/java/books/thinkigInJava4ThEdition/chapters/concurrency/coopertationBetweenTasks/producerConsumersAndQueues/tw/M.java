package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.producerConsumersAndQueues.tw;

class M {

    private final int count;

    public M(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "M{" +
                "count=" + count +
                '}';
    }
}
