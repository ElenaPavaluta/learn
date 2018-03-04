package books.thinkigInJava4ThEdition.chapters.concurrency.terminatingTasks.checkingForAnInterrupt;

import java.util.concurrent.TimeUnit;

class Blocked implements Runnable {
    private volatile double d = 0.0;

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                NeedsCleanUp nc = new NeedsCleanUp(1);
                try {
                    System.out.println("Sleeping");
                    TimeUnit.SECONDS.sleep(2);
                    NeedsCleanUp nc2 = new NeedsCleanUp(2);
                    try {
                        System.out.println("Calculating");
                        for(int i = 1; i < 2500000; i++) {
                            d = d + (Math.PI + Math.E) / d;
                        }
                        System.out.println("Finished time consuming op");
                    } finally {
                        nc2.cleanUp();
                    }

                } finally {
                    nc.cleanUp();
                }
            }
            System.out.println("Exiting via while() test");
        } catch(InterruptedException e) {
            System.out.println("Exiting via InterruptedException");
        }
    }
}
