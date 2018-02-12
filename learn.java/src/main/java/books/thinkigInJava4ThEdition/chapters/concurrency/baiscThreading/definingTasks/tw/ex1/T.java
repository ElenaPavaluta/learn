package books.thinkigInJava4ThEdition.chapters.concurrency.baiscThreading.definingTasks.tw.ex1;

import java.util.stream.Stream;

class T implements Runnable {

    int n;

    public T(int n) {
        this.n = n;
        System.out.println("£: " + n);
    }

    @Override
    public void run() {
        Stream.iterate(1, i->i+1)
                .limit(3)
                .forEach(i->{m(i); Thread.yield();});
    }

    private void m(int i) {
        System.out.println("£: " + n + " start: " +i);
        Thread.yield();
        System.out.println("£: " + n + " end: " +i);
    }
}
