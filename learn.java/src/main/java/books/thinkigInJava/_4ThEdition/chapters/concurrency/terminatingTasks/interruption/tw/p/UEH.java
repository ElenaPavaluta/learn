package books.thinkigInJava._4ThEdition.chapters.concurrency.terminatingTasks.interruption.tw.p;

class UEH implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Thread dishName: " + t.getName() + "; " + e.getMessage());
    }
}
