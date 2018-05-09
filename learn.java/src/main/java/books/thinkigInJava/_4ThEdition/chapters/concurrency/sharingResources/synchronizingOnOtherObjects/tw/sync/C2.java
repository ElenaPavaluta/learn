package books.thinkigInJava._4ThEdition.chapters.concurrency.sharingResources.synchronizingOnOtherObjects.tw.sync;

class C2 extends C {

    @Override
    synchronized void increment() {
        super.increment();
    }
}
