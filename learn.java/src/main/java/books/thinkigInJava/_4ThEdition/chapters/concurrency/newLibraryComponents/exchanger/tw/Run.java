package books.thinkigInJava._4ThEdition.chapters.concurrency.newLibraryComponents.exchanger.tw;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Run {
    ExecutorService exec = Executors.newCachedThreadPool();
    Exchanger<Base> exchanger = new Exchanger<>();

    void m(){
        C c = new C();
        R rc = new R(exchanger, c);

        D d = new D();
        R rd  = new R(exchanger, d);

        exec.execute(rc);
        exec.execute(rd);

        exec.shutdown();
    }

    public static void main(String[] args) {
        new Run().m();
    }
}
