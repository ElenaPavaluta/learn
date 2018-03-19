package books.thinkigInJava4ThEdition.chapters.concurrency.newLibraryComponents.priorityBlockingQueue.tw;

class Buffer {
    private StringBuilder sb = new StringBuilder();

    synchronized String get() {
       return sb.toString();
    }

    synchronized void add(char c) {
        sb.append(c);
    }
}
