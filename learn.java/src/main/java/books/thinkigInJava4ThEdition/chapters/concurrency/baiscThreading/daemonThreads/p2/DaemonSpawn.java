package books.thinkigInJava4ThEdition.chapters.concurrency.baiscThreading.daemonThreads.p2;

class DaemonSpawn implements Runnable {
    @Override
    public void run() {
        while(true){
            Thread.yield();
        }
    }
}
