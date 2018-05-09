package books.thinkigInJava._4ThEdition.chapters.concurrency.sharingResources.criticalSections;

class PairManager1 extends PairManager {
    @Override
    protected synchronized void increment() {
        this.p.incrementX();
        this.p.incrementX();
        store(getPair());
    }
}
