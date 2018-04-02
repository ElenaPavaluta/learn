package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.distributingWork.ex.ex_38;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Demo {

    public static void main(String[] args) throws InterruptedException {
        WorkerPool pool = new WorkerPool();
        Builder builder = new Builder(pool);
        ExecutorService exec = Executors.newCachedThreadPool();

        pool.add(new WindowWorker(pool));
        pool.add(new DoorWorker(pool));
        pool.add(new FoundationWorker(pool));
        pool.add(new NbWorker(pool));
        pool.add(new FrameWorker(pool));
        pool.add(new RoofWorker(pool));
        pool.startAll(exec);
        exec.execute(builder);
        TimeUnit.MILLISECONDS.sleep(100);
        exec.shutdownNow();
    }
}
