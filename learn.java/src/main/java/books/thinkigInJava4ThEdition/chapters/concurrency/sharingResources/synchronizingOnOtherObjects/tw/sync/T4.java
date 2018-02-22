package books.thinkigInJava4ThEdition.chapters.concurrency.sharingResources.synchronizingOnOtherObjects.tw.sync;

import java.util.function.Predicate;

class T4 implements Runnable {
    static Predicate<C> pred = c -> c.getI() >= 0 && c.getI() < Integer.MAX_VALUE;
    private C c = new C();


    @Override
    public void run() {
        while(pred.test(c)) {
            synchronized(c) {
                c.increment();
            }

            synchronized(c) {
                int i = c.getI();
                if(i % 2 != 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
