package books.thinkigInJava._4ThEdition.chapters.concurrency.sharingResources.criticalSections;

class PairChecker implements Runnable {

    private PairManager pm;

    public PairChecker(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while(true){
            pm.atomicInteger.incrementAndGet();
            pm.getPair().checkState();
        }
    }
}
