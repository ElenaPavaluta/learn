package books.thinkigInJava4ThEdition.chapters.concurrency.terminatingTasks.interruption.ex.ex_18;

class R implements Runnable {
    C c = new C();

    @Override
    public void run() {
        c.m();
    }

    public static void main(String[] args) {
        m();
    }

    private static void m() {
        Thread t = new Thread(new R());
        t.start();
        t.interrupt();
    }
}
