package books.thinkigInJava4ThEdition.chapters.concurrency.terminatingTasks.interruption;

class SynchronizedBlock implements Runnable {

    synchronized void f() {
        while (true) {
            Thread.yield();
        }
    }

    SynchronizedBlock(){
        new Thread(){
            @Override
            public void run() {
                f();
            }
        }.start();
    }

    @Override
    public void run() {
        System.out.println("Trying to call f()");
        f();
        System.out.println("Exiting Synchronized run()");
    }
}
