package books.thinkigInJava._4ThEdition.chapters.concurrency.sharingResources.synchronizingOnOtherObjects;

class Run {

    static void m(){
        final DualSync ds = new DualSync();
        new Thread(){
            @Override
            public void run() {
                ds.f();
            }
        }.start();
        ds.g();
    }

    public static void main(String[] args) {
        m();
    }
}
