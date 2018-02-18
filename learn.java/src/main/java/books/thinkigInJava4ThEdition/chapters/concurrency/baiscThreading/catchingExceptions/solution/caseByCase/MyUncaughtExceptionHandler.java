package books.thinkigInJava4ThEdition.chapters.concurrency.baiscThreading.catchingExceptions.solution.caseByCase;

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught: " +e.getClass().getSimpleName());
    }
}
