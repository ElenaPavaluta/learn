package books.thinkigInJava._4ThEdition.chapters.concurrency.newLibraryComponents.cyclicBarrier.tw;

import java.util.concurrent.CyclicBarrier;

class CB {
    CyclicBarrier cyclicBarrier;
    Runnable r =()->{};

    {
        cyclicBarrier = new CyclicBarrier(2);

        cyclicBarrier = new CyclicBarrier(2, r);
    }
}
