package books.thinkigInJava._4ThEdition.chapters.concurrency.sharingResources.synchronizingOnOtherObjects.tw.sync.oneVsMore;

import java.util.concurrent.TimeUnit;

class R implements Runnable {

    AnObj ao =new AnObj();

    @Override
    public void run() {
        synchronized(ao){
            System.out.println("id enter: " + Thread.currentThread().getId());
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            ao.m();
            System.out.println("id exit " + Thread.currentThread().getId());
        }
    }
}
