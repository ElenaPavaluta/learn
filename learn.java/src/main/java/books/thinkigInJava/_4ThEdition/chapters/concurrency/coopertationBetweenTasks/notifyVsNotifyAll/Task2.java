package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.notifyVsNotifyAll;

class Task2 implements Runnable {
    //A separate Blocker obj
    static Blocker blocker = new Blocker();

    @Override
    public void run() {
        blocker.waitingCall();
    }
}
