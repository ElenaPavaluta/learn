package books.thinkigInJava._4ThEdition.chapters.concurrency.deadlock;

import java.util.concurrent.BlockingQueue;

class Philosopher_ex_31 extends Philosopher {

    private BlockingQueue<Chopstick> queue;

    Philosopher_ex_31(Chopstick left, Chopstick right, int id, int ponderFactor, BlockingQueue<Chopstick> queue) {
        super(left, right, id, ponderFactor);
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println(this.id + " thinking");
                pause();
                System.out.println(this.id + " grabbing right");
                if (right == null) {
                    right = queue.take();
                }
                right.take();
                System.out.println(this.id + " grabbing left");
                if (left == null) {
                    left = queue.take();
                }
                left.take();
                System.out.println(this.id + " eating");
                pause();
                queue.put(right);
                right.drop();
                right = null;
                queue.put(left);
                left.drop();
                left = null;
            }
        } catch (InterruptedException e) {
            System.out.println(this.id + " exiting via interrupt");
        }
    }
}
