package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.blockingQueuesOfToast.ex.ex_29;

import java.util.function.Supplier;

class SliceOfBreadProvider implements Supplier<SliceOfBread> {
    private int count;

    @Override
    public synchronized SliceOfBread get() {
        return new SliceOfBread(++count, Status.NEW);
    }


}
