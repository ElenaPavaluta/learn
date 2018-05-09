package books.thinkigInJava._4ThEdition.chapters.concurrency.baiscThreading.priority.tw;

class R {

    static void tc() {
        double d = 0;
        for(int i = 1; i < 100_000_000; i++) {
            d += (Math.PI + Math.E) / (double) i;
            if(i % 1_000 == 0) {
                Thread.yield();
            }
        }
    }

    static void t() {
        Thread t = new Thread(() -> {
            tc();
            System.out.println("t");
        });
        t.start();
        t.setPriority(Thread.MAX_PRIORITY);  //unlike the setDaemon() method doesn't throw a IllegalStateException (RE)
    }

    static void t2() {
        Thread t = new Thread(() -> {
            tc();
            System.out.println("t2");
        });
        t.start();
        t.setPriority(Thread.MIN_PRIORITY);
    }

    public static void main(String[] args) {
        t2();
        t();
    }
}
