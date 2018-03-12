package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.blockingQueuesOfToast.ex.ex_29;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Eater implements Runnable {
    Queue lineJam;
    Queue linePeanutButter;
    Queue eaten;

    Eater(Queue lineJam, Queue linePeanutButter, Queue eaten) {
        this.lineJam = lineJam;
        this.linePeanutButter = linePeanutButter;
        this.eaten = eaten;
    }

    Runnable rj  = () -> {
        try {
            while (!Thread.interrupted() || !lineJam.isEmpty()){
               SliceOfBread slice = lineJam.take();
               eaten.put(slice);
                System.out.println("Eaten: " + slice);
            }
        }catch (InterruptedException e){
            System.out.println("rj interrupted");
        }
    };

    Runnable rpb = () ->{
        try {
            while (!Thread.interrupted() || !linePeanutButter.isEmpty()){
                SliceOfBread s = linePeanutButter.take();
                eaten.put(s);
                System.out.println("Eaten: " + s);
            }
        }catch (InterruptedException e){
            System.out.println("rpb interrupted");
        }
    };


    @Override
    public void run() {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(rj);
        exec.execute(rpb);
        exec.shutdown();
    }
}
