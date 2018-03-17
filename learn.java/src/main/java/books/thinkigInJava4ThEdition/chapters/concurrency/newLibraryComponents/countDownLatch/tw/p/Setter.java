package books.thinkigInJava4ThEdition.chapters.concurrency.newLibraryComponents.countDownLatch.tw.p;

import java.util.concurrent.CountDownLatch;

class Setter implements Runnable {
    private Square square;
    private CountDownLatch countDownLatch;
    private int x, y;

    public Setter(Square square, CountDownLatch countDownLatch, int x, int y) {
        this.square = square;
        this.countDownLatch = countDownLatch;
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        System.out.println(this.getClass().getSimpleName()+ " " + Thread.currentThread().getId());
        square.set(x, y);
        countDownLatch.countDown();
    }
}
