package books.thinkigInJava._4ThEdition.chapters.concurrency.baiscThreading.codingVariations;

import java.util.concurrent.TimeUnit;

class InnerThread1 {

    int countDown = 5;
    Inner inner;

    InnerThread1(String name) {
        inner = new Inner(name);
    }

    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            new InnerThread1(Integer.toString(i));
        }
    }

    private class Inner extends Thread {
        Inner(String name) {
            super(name);
            start();
        }

        @Override
        public void run() {
            try {
                while(true) {
                    System.out.println(this);
                    if(--countDown == 0) {
                        return;
                    }
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            } catch(InterruptedException e) {
                System.out.println("interrupted");
            }
        }

        @Override
        public String toString() {
            return getName() + ": " + countDown;
        }
    }

}
