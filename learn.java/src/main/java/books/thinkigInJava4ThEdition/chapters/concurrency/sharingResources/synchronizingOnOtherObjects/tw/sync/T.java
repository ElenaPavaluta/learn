package books.thinkigInJava4ThEdition.chapters.concurrency.sharingResources.synchronizingOnOtherObjects.tw.sync;

import java.util.function.Predicate;

class T implements Runnable {

    static Predicate<C> pred = c -> c.getI() >= 0 && c.getI() < Integer.MAX_VALUE;
    private C c = new C();


    @Override
    public void run() {
        while(pred.test(c)) {
            synchronized(this) {
                c.increment();
            }

            /**
             * Due to the fact that the getI() method access is not synchronized
             * i can ne retrieved in an inconsistent state (odd nb)
             */
//            int i = c.getI();
            synchronized(this) {
                int i = c.getI();
                if(i % 2 != 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
//        System.out.println(c.getI());
    }
}
