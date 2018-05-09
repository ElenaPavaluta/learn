package books.thinkigInJava._4ThEdition.chapters.concurrency.sharingResources.criticalSections;

class PairManager2 extends PairManager {
    @Override
    protected void increment() {
        Pair temp;
        synchronized(this){
            p.incrementX();
            p.incrementY();
            temp = getPair();
        }
        store(temp);
    }
}
