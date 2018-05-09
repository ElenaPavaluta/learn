package books.thinkigInJava._4ThEdition.chapters.concurrency.sharingResources.synchronizingOnOtherObjects.tw.sync;

import java.util.function.Predicate;

class T3 implements Runnable {
    static Predicate<C2> pred2 = c2 -> c2.getI() >= 0 && c2.getI() < Integer.MAX_VALUE;
    private C2 c2 = new C2();


    @Override
    public void run() {
        while(pred2.test(c2)) {
            /**
             * Due to the fact that the synchronized c2.increment() uses
             * c.increment() (which is not synchronized )
             * the result is that the i variable will be left in an inconsistent state
             */
//            c2.increment();

            synchronized(this) {
                c2.increment();
                int i = c2.getI();
                if(i % 2 != 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
