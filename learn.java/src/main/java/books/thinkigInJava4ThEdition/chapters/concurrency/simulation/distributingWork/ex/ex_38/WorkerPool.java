package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.distributingWork.ex.ex_38;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;

class WorkerPool {
    private Set<Worker> pool = new HashSet<>();

    void startAll(ExecutorService exec){
        pool.forEach(exec::execute);
    }

    synchronized void add(Worker worker) {
        pool.add(worker);
        notifyAll();
    }

    void release(Worker worker) {
        add(worker);
    }

    synchronized void hire(Class<? extends Worker> workerType, Builder builder) throws InterruptedException {
        for(Worker w : pool) {
            if(w.getClass().equals(workerType)) {
                pool.remove(w);
                w.start(builder);
                return;
            }
        }
        wait();
        hire(workerType, builder);
    }
}
