package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.blockingQueuesOfToast.ex.ex_29;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

class Toaster implements Runnable {

    private Supplier<SliceOfBread> supplier;
    private Queue toasted;
    private Random rand = new Random(47);

    Toaster(Supplier<SliceOfBread> supplier, Queue toasted) {
        this.supplier = supplier;
        this.toasted = toasted;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(
                        100 + rand.nextInt(500));
                SliceOfBread sliceOfBread = supplier.get();
                System.out.println(sliceOfBread);
                sliceOfBread.setStatus(Status.TOAST);
                toasted.put(sliceOfBread);
                System.out.println(sliceOfBread);
            }
        }catch (InterruptedException e){
            System.out.println("Toaster interrupted");
        }
    }
}
