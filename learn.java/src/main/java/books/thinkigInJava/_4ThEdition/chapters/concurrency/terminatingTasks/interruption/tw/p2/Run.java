package books.thinkigInJava._4ThEdition.chapters.concurrency.terminatingTasks.interruption.tw.p2;

class Run {

    static void m(){
        R r = new R();
        Thread t = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        Thread.setDefaultUncaughtExceptionHandler((run, thrw)->{
            System.out.println(run.getId() + ": " +thrw.getMessage());
        });

        t.start();
        t2.start();
        t3.start();

        System.out.println("All threads started");

        t3.interrupt();
        t2.interrupt();
        t.interrupt();

        System.out.println("All threads stopped");

        System.out.println("Main dropped the mike");
    }

    public static void main(String[] args) {
        m();
    }
}
