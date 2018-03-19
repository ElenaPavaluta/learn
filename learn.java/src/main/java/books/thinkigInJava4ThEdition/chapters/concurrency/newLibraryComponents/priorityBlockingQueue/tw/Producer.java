package books.thinkigInJava4ThEdition.chapters.concurrency.newLibraryComponents.priorityBlockingQueue.tw;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

class Producer implements Runnable {
    private BlockingQueue<Task> queue;
    private ExecutorService exec;
    Buffer b = new Buffer();

    private Runnable rmm = () -> mm();
    private Runnable rmM = () -> mM();
    private Runnable rmi = () -> mi();


    public Producer(BlockingQueue<Task> queue, ExecutorService exec) {
        this.queue = queue;
        this.exec = exec;
    }

    @Override
    public void run() {
        exec.execute(rmm);
        exec.execute(rmi);
        exec.execute(rmM);
        putEnd();
    }

    private void putEnd() {
        try {
            queue.put(new Task.EndTask(b, exec));
        } catch(InterruptedException e) {
            System.out.println(e);
        }
    }

    synchronized void mm() {
        for(char c = 'a'; c <= 'z'; c++) {
            try {
                put(c);
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    private synchronized void put(char c) throws InterruptedException {
        queue.put(new Task(c, c, b));
    }

    synchronized void mM() {
        for(char c = 'A'; c <= 'Z'; c++) {
            try {
                put(c);
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
    }


    synchronized void mi() {
        for(char c = '0'; c <= '9'; c++) {
            try {
                put(c);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
