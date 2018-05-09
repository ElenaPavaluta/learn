package books.thinkigInJava._4ThEdition.chapters.concurrency.sharingResources.synchronizingOnOtherObjects.tw.sync;

import java.time.LocalDate;
import java.util.function.Predicate;

class T2 implements Runnable {

    static Predicate<C> pred = c -> c.getI() >= 0 && c.getI() < Integer.MAX_VALUE;
    private C c = new C();
    final private LocalDate localDate = LocalDate.now();

    @Override
    public void run() {
        while(pred.test(c)) {
            synchronized(localDate) {
                c.increment();
            }

            synchronized(this) {
                int i = c.getI();
                if(i % 2 != 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
