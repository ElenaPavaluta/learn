package books.thinkigInJava4ThEdition.chapters.concurrency.baiscThreading.codingVariations;

import java.util.stream.IntStream;

class InnerRunnable1 {

    int countDown = 5;
    private Inner inner;

    InnerRunnable1(String name) {
        inner = new Inner(name);
    }

    public static void main(String[] args) {
        IntStream.
                         rangeClosed(1, 5).
                         forEach(i -> new InnerRunnable1(Integer.toString(i)));
    }

    private class Inner implements Runnable {
        Thread t;

        Inner(String name) {
            t = new Thread(this, name);
            t.start();
        }

        public void run() {
            try {
                while(true) {
                    System.out.println(this);
                    if(--countDown == 0) return;
//                    TimeUnit.MILLISECONDS.sleep(10);
                    Thread.yield();
                }
//            } catch(InterruptedException e) {
//                System.out.println("sleep() interrupted");
            }
            finally {

            }
        }

        public String toString() {
            return t.getName() + ": " + countDown;
        }
    }


}
