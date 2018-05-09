package books.thinkigInJava._4ThEdition.chapters.concurrency.baiscThreading.catchingExceptions.solution.caseByCase;

class ExceptionThread implements Runnable{
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t.getName());
        System.out.println("eh = " + t.getUncaughtExceptionHandler().getClass().getSimpleName());
        throw new RuntimeException();
    }

}
