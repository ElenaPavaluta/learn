package books.thinkigInJava4ThEdition.chapters.concurrency.terminatingTasks.interruption.ex.ex_18;

import java.util.concurrent.TimeUnit;

class C {

    void m() {
        System.out.println("C m() enter");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch(InterruptedException e) {
            System.out.println("caught InterruptedException in C ()");
        }
        System.out.println("C m() end");
    }
}
