package books.thinkigInJava4ThEdition.chapters.concurrency.newLibraryComponents.priorityBlockingQueue.tw;

import java.util.concurrent.ExecutorService;

class Task implements Runnable, Comparable<Task> {

    protected Buffer b;
    private char c;
    private int priority;

    public Task(char c, int priority, Buffer b) {
        this.c = c;
        this.priority = priority;
        this.b = b;
    }

    @Override
    public void run() {
        b.add(c);
    }

    @Override
    public int compareTo(Task o) {
        return Integer.compare(priority, o.priority);
    }

    static class EndTask extends Task {
        private ExecutorService exec;

        public EndTask(Buffer b, ExecutorService exec) {
            super(' ', Integer.MIN_VALUE, b);
            this.exec = exec;
        }

        @Override
        public void run() {
            System.out.println(b.get());
            exec.shutdownNow();

        }
    }
}
