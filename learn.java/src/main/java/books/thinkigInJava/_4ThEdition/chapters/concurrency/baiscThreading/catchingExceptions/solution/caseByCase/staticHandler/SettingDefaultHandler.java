package books.thinkigInJava._4ThEdition.chapters.concurrency.baiscThreading.catchingExceptions.solution.caseByCase.staticHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SettingDefaultHandler {

    static void m(){
        Thread.setDefaultUncaughtExceptionHandler((t,e)-> System.out.println(e.getClass().getSimpleName()));

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(()->{throw new RuntimeException();});
    }

    public static void main(String[] args) {
        m();
    }
}
