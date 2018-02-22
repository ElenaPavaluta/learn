package books.thinkigInJava4ThEdition.chapters.concurrency.sharingResources.synchronizingOnOtherObjects;

class DualSync {

    private Object syncObject = new Object();
    synchronized void f(){
        for(int i= 0; i<5; i++){
            System.out.println("f()");
            Thread.yield();
        }
    }

    void g(){
        synchronized(syncObject){
            for(int i =0; i<5; i++){
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}
