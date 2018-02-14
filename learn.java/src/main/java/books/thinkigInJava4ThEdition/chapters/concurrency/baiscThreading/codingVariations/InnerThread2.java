package books.thinkigInJava4ThEdition.chapters.concurrency.baiscThreading.codingVariations;

import java.util.concurrent.TimeUnit;

class InnerThread2 {

    int countDown = 5;
    private Thread t;

    InnerThread2(String name) {

        //anonymous inner class
        t = new Thread(name) {
            @Override
            public void run() {
                try {
                    while(true) {
                        System.out.println(this);
                        if(--countDown == 0) return;
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                } catch(InterruptedException e) {
                    System.out.println("sleep() interrupted");
                }
            }

            @Override
            public String toString() {
                return getName() + ": " + countDown;
            }
        };
        t.start();
    }

    public static void main(String[] args) {
        for(int i = 0; i<5; i++){
            new InnerThread2(Integer.toString(i));
        }
    }
}
