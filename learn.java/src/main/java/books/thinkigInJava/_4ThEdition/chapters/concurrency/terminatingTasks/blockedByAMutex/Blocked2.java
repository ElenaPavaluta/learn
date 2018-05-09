package books.thinkigInJava._4ThEdition.chapters.concurrency.terminatingTasks.blockedByAMutex;

class Blocked2 implements Runnable{
    BlockedMutex bm = new BlockedMutex();

    @Override
    public void run() {
        System.out.println("The accesing resource thread: " + Thread.currentThread().getId());
        System.out.println("Waiting for f() in BlockedMutex");
        bm.f();
        System.out.println("Broken out blocked call");
    }
}
