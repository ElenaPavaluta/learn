package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.notifyVsNotifyAll;

class Task implements Runnable {
    static Blocker blocker = new Blocker();

    @Override
    public void run() {
        blocker.waitingCall();
    }
}
