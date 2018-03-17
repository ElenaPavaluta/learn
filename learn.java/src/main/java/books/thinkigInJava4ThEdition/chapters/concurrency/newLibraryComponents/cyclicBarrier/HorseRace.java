package books.thinkigInJava4ThEdition.chapters.concurrency.newLibraryComponents.cyclicBarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class HorseRace {

    static final int FINISH_LINE = 75;
    private List<Horse> horses = new ArrayList<>();
    private ExecutorService exec = Executors.newCachedThreadPool();
    private CyclicBarrier barrier;

    HorseRace(int nHorse, final int pause) {
        barrier = new CyclicBarrier(nHorse, new Runnable() {
            @Override
            public void run() {
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < FINISH_LINE; i++) {
                    sb.append("=");
                }
                System.out.println(sb);
                horses.forEach(horse -> System.out.println(horse.tracks()));
                horses.forEach(horse -> {
                    if(horse.getStrides() >= FINISH_LINE) {
                        System.out.println(horse + " won");
                        exec.shutdownNow();
                        return;
                    }
                });
                try {
                    TimeUnit.MILLISECONDS.sleep(pause);
                } catch(InterruptedException e) {
                    System.out.println("barrier-action-sleep interrupted");
                    System.exit(0);
                }
            }
        });
        for(int i = 0; i < nHorse; i++) {
            Horse horse = new Horse(barrier);
            horses.add(horse);
            exec.execute(horse);
        }
    }

    static void m() {
        int nHorses = 10;
        int pause = 20;
        new HorseRace(nHorses, pause);
    }

    public static void main(String[] args) {
        m();
    }
}
