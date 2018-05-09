package books.thinkigInJava._4ThEdition.chapters.concurrency.sharingResources.synchronizingOnOtherObjects.tw.sync;

class C {

    private int i;

    void increment() {
        i++;
        Thread.yield();
        i++;
    }

    int getI(){
        return i;
    }
}
