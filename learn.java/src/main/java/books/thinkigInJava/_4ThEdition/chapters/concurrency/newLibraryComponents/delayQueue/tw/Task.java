package books.thinkigInJava._4ThEdition.chapters.concurrency.newLibraryComponents.delayQueue.tw;

import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

class Task implements Runnable, Delayed {
    protected Buffer buffer;
    private long initialDelay;
    private long remainingDelay;
    private String s;

    public Task(long delay, Buffer buffer, String s) {
        this.initialDelay = delay;
        remainingDelay = System.nanoTime() + TimeUnit.NANOSECONDS.convert(initialDelay, TimeUnit.MILLISECONDS);
        this.buffer = buffer;
        this.s = s;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(remainingDelay - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        Task t = (Task) o;
        return Long.compare(remainingDelay, t.remainingDelay);
    }

    @Override
    public void run() {
        buffer.add(s);
    }
}

class Print extends Task {
    public Print(long delay, Buffer buffer, String s) {
        super(delay, buffer, s);
    }

    @Override
    public void run() {
        super.run();
    }
}

class End extends Task{
    private ExecutorService exec;
    public End(long delay, Buffer buffer, String s, ExecutorService exec) {
        super(delay, buffer, s);
        this.exec = exec;
    }

    @Override
    public void run() {
        super.run();
        buffer.print();
       exec.shutdownNow();
    }
}
