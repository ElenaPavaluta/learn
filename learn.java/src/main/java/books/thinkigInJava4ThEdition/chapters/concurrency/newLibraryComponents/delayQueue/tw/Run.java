package books.thinkigInJava4ThEdition.chapters.concurrency.newLibraryComponents.delayQueue.tw;

import javax.sound.midi.SoundbankResource;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Run {
    private DelayQueue<Task> queue = new DelayQueue<>();
    private ExecutorService exec = Executors.newCachedThreadPool();
    private Buffer buffer = new Buffer();
    private Runnable consumer = () -> {
        try {
            while(!Thread.interrupted()) {
                queue.take().run();
            }
        } catch(InterruptedException e) {
            System.out.println("consumer interrupted: " + e);
        }
    };

    {
        queue.put(new Task(100, buffer, "Ana"));
        queue.add(new End(500, buffer, "| shutdown", exec));
        queue.put(new Print(400, buffer, "| print"));
        queue.put(new Task(300, buffer, "apple"));
        queue.put(new Task(200, buffer, "has"));

        System.out.println("queue size: " + queue.size());
    }

    public static void main(String[] args) throws InterruptedException {
        Run r = new Run();
//        r.m();
//        r.m2();
        r.m3();
    }

    void m() {
        queue.forEach(exec::execute);
    }

    void m2() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        queue.forEach(exec::execute);
    }

    void m3() throws InterruptedException {
        exec.execute(consumer);
        exec.execute(consumer);
        exec.execute(consumer);
        TimeUnit.SECONDS.sleep(1);
        buffer.print();
    }

}
