package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.blockingQueuesOfToast.ex.ex_29;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

class Run {
    Supplier<SliceOfBread> supplier = new SliceOfBreadProvider();
    Queue toasted = new Queue();
    Toaster toaster = new Toaster(supplier, toasted);


    Queue butter = new Queue(),
            jam = new Queue(),
            peanutButter = new Queue(),
            eaten = new Queue();

    void m() throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(toaster);
        exec.execute(new Butterer(toasted, butter));
        exec.execute(new Jammer(butter, jam));
        exec.execute(new PeanutButterer(toasted, peanutButter));
        exec.execute(new Eater(jam, peanutButter, eaten));

        TimeUnit.SECONDS.sleep(3);
        exec.shutdownNow();
    }

    public static void main(String[] args) throws InterruptedException {
        new Run().m();
    }


}
