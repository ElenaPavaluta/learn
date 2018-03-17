package books.thinkigInJava4ThEdition.chapters.concurrency.newLibraryComponents.delayQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

class DelayedTask implements Runnable, Delayed {

    protected static List<DelayedTask> sequence = new ArrayList<>();
    private static int counter = 0;
    private final int id = counter++;
    private final int delta;
    private final long trigger;

    DelayedTask(int delayInMilliseconds) {
        delta = delayInMilliseconds;
        trigger = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delta, TimeUnit.MILLISECONDS);
    }


    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger - System.nanoTime(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        DelayedTask that = (DelayedTask) o;
        if(trigger < that.trigger) return -1;
        if(trigger > that.trigger) return 1;
        return 0;
    }

    @Override
    public void run() {
        System.out.println(this + " ");
    }

    public String toString() {
        return String.format("[%1$-4d]", delta) +
                " Task " + id;
    }

    String summary(){
        return "(" + id + ": " + delta + ")";
    }

    static class EndSentinel extends DelayedTask{
        private ExecutorService exec;
        public EndSentinel(int delayInMilliseconds, ExecutorService exec) {
            super(delayInMilliseconds);
            this.exec = exec;
        }

        @Override
        public void run() {
            for(DelayedTask pt: sequence){
                System.out.println(pt.summary() + " ");
            }
            System.out.println();
            System.out.println(this + " calling shutdownNow()");
            exec.shutdownNow();
        }
    }
}
