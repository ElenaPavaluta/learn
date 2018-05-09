package books.thinkigInJava._4ThEdition.chapters.concurrency.sharingResources.criticalSections;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class CriticalSection {

    static void testAproaches(PairManager pairManeger1, PairManager pairManager2){
        ExecutorService exec = Executors.newCachedThreadPool();

        PairManipulator pm1 = new PairManipulator(pairManeger1),
                pm2 = new PairManipulator(pairManager2);

        PairChecker pcheck1 = new PairChecker(pairManeger1),
                pcheck2 = new PairChecker(pairManager2);

        exec.execute(pm1);
        exec.execute(pm2);
        exec.execute(pcheck1);
        exec.execute(pcheck2);

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch(InterruptedException e) {
            System.out.println("sleep() interrupted");
        }

        System.out.println("pm1: " + pm1 + "\npm2: " + pm2);
    }

    static void m(){
        PairManager pman1 = new PairManager1(),
                pman2 = new PairManager2();
        testAproaches(pman1, pman2);
    }

    public static void main(String[] args) {
        m();
    }
}
