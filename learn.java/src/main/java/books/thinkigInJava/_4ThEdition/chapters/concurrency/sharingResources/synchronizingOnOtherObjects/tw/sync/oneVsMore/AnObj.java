package books.thinkigInJava._4ThEdition.chapters.concurrency.sharingResources.synchronizingOnOtherObjects.tw.sync.oneVsMore;

import java.util.concurrent.TimeUnit;

class AnObj {

    int i = 0;

    void m(){
        i++;
        try {
            System.out.println("AnObj m enter: " + Thread.currentThread().getId());
            TimeUnit.MILLISECONDS.sleep(10);
            System.out.println("AnObj m exit: " + Thread.currentThread().getId());
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("i: " + i);
    }
}
