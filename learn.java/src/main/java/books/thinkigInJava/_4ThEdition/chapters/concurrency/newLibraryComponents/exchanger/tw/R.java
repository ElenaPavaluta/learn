package books.thinkigInJava._4ThEdition.chapters.concurrency.newLibraryComponents.exchanger.tw;

import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

class R implements Runnable{

    private static int count = 0;
    private final int id = count ++;
    private Random rand = new Random(47);

    private Exchanger<Base> exchanger;
    private Base obj;
    private String s = "id: " + id + " | ";

    public R(Exchanger<Base> exchanger, Base obj) {
        this.exchanger = exchanger;
        this.obj = obj;
    }

    @Override
    public void run() {
        try {
            fill(true);
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
            obj = exchanger.exchange(obj);
            fill(true);
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
            obj = exchanger.exchange(obj);
            fill(false);
            System.out.println(s);
        } catch(InterruptedException e) {
            System.out.println("id: " + id + " interrupted");
        }
    }

    synchronized void fill(boolean hasNxt){
        s = s + obj.toString();
        if(hasNxt){
            s = s + " -> ";
        }
    }
}
