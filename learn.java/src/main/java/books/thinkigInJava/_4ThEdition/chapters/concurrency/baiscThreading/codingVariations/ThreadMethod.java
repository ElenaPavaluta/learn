package books.thinkigInJava._4ThEdition.chapters.concurrency.baiscThreading.codingVariations;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class ThreadMethod {

    int countDown =5;
    Thread t;
    String name;

    ThreadMethod(String name){
        this.name = name;
    }

   void runTask(){
        if(t == null){
            t = new Thread(name){
                @Override
                public void run() {
                    try{
                        while(true){
                            System.out.println(this);
                            if(--countDown == 0) return;
                            TimeUnit.MILLISECONDS.sleep(10);
                        }
                    }catch(InterruptedException e){
                        System.out.println("sleep() + interrupted");
                    }
                }

                public String toString() {
                    return getName() + ": " + countDown;
                }
            };
        }
        t.start();
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(0,5)
                 .forEach(i-> new ThreadMethod(Integer.toString(i)).runTask());
    }


}
