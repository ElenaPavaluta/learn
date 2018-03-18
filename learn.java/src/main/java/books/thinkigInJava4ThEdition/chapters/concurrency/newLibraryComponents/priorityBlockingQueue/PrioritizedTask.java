package books.thinkigInJava4ThEdition.chapters.concurrency.newLibraryComponents.priorityBlockingQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

class PrioritizedTask implements Runnable, Comparable<PrioritizedTask> {
    protected static List<PrioritizedTask> sequence = new ArrayList<PrioritizedTask>();
    private static int counter = 0;
    private final int id = counter++;
    private final int priority;
    private Random rand = new Random(47);

    public PrioritizedTask(int priority) {
        this.priority = priority;
        sequence.add(this);
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(250));
        } catch(InterruptedException e) {
            //acceptable way to exit
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "PrioritizedTask{" +
                "id=" + id +
                ", priority=" + priority +
                '}';
    }

    String summary(){
        return "(" + id + ": " + priority + ")";
    }

    @Override
    public int compareTo(PrioritizedTask o) {
        return Integer.compare(priority, o.priority);
    }

    static class EndSentinel extends PrioritizedTask{
        private ExecutorService exec;
        public EndSentinel(ExecutorService exec) {
            //lowest priority in this program
            super(-1);
            this.exec = exec;
        }

        @Override
        public void run() {
           int count = 0;
           for(PrioritizedTask pt: sequence){
               System.out.println(pt.summary());
               if(++count %5 ==0){
                   System.out.println();
               }
           }
            System.out.println();
            System.out.println(this + " Calling shutdownNow()");
            exec.shutdownNow();
        }
    }
}
