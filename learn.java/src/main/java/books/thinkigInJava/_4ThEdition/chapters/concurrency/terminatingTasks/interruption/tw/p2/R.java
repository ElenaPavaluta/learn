package books.thinkigInJava._4ThEdition.chapters.concurrency.terminatingTasks.interruption.tw.p2;

class R implements Runnable {

    @Override
    public void run() {
        int i = 0;
        while(true) {
            i = (int) ((i + Math.random()) / (Math.random() + Math.PI - Math.E * 2.1/3.5));
            Thread.yield();
            System.out.println(Thread.currentThread().getId() + " " + i);
        }
    }
}
