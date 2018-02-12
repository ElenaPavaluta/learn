package books.thinkigInJava4ThEdition.chapters.concurrency.baiscThreading.sleeping.ex6;

import java.util.concurrent.TimeUnit;

class T implements Runnable{

    @Override
    public void run() {
        int n = (int)(Math.random() *1000);
        System.out.println("sleep for: " + n);
        try {
            TimeUnit.MILLISECONDS.sleep(n);
        } catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("out");
    }

    static void m(){
        for(int i =0; i<5; i++ ){
            new Thread(new T()).start();
        }
    }

    public static void main(String[] args) {
        m();
    }
}
