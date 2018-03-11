package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers.ex.ex_24;

class Buffer {

    private int max = 100, index = 0;
    private int[] buffer = new int[max];

    synchronized boolean empty(){
        return index==0;
    }

    synchronized boolean full(){
        return index ==max;
    }

    synchronized void add(int nr) {
        buffer[index++] = nr;
    }

    synchronized int remove() {
        return buffer[--index];
    }
}
