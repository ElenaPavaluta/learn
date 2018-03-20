package books.thinkigInJava4ThEdition.chapters.concurrency.newLibraryComponents.theGreenHouseControllerWithScheduledExecutor;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

class GreenHouseScheduler {

    static ExecutorService exec = Executors.newCachedThreadPool();
    //        ScheduledExecutorService ses = Executors.newScheduledThreadPool(20);
    ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(10);
    List<DataPoint> data = Collections.synchronizedList(new ArrayList<>());
    private volatile boolean light = false;
    private volatile boolean water = false;
    private String thermostat = "Day";
    private LocalDateTime lastTime = LocalDateTime.now();
    private float lastTemp = 65.0f;
    private int tempDirection = +1;
    private float lastHumidity = 50.0f;
    private int humidityDirection = +1;
    private Random rand = new Random(47);


    public static void main(String[] args) throws InterruptedException {
//        m();
        mDelay();
    }

    private static void m(){
        GreenHouseScheduler gh = new GreenHouseScheduler();
        gh.schedule(gh.new Terminate(), 5000);

        gh.repeat(gh.new Bell(), 0, 1000);
        gh.repeat(gh.new ThermostatNight(), 0, 2000);
        gh.repeat(gh.new LightOn(), 0, 200);
        gh.repeat(gh.new LightOff(), 0, 400);
        gh.repeat(gh.new WaterOn(), 0, 600);
        gh.repeat(gh.new WaterOff(), 0, 800);
        gh.repeat(gh.new ThermostatDay(), 0, 1400);
        gh.repeat(gh.new CollectionData(), 500, 500);


    }

    private static void mDelay() throws InterruptedException {
        DelayQueue<Repeat> queue = new DelayQueue<>();
        GreenHouseScheduler gh = new GreenHouseScheduler();


        exec.execute(new Repeat(gh.new Bell(), 0, 1000, queue));
        exec.execute(new Repeat(gh.new ThermostatNight(), 0, 2000, queue));
        exec.execute(new Repeat(gh.new LightOn(), 0, 200, queue));
        exec.execute(new Repeat(gh.new LightOff(), 0, 400, queue));
        exec.execute(new Repeat(gh.new WaterOn(), 0, 600, queue));
        exec.execute(new Repeat(gh.new WaterOff(), 0, 800, queue));
        exec.execute(new Repeat(gh.new ThermostatDay(), 0, 1400, queue));
        exec.execute(new Repeat(gh.new CollectionData(), 500, 500, queue));

        TimeUnit.MILLISECONDS.sleep(5000);
        exec.execute(new Repeat(gh.new TerminateDelay(), 5000, 0, queue));

    }

    synchronized String getThermostat() {
        return thermostat;
    }

    synchronized void setThermostat(String val) {
        this.thermostat = val;
    }

    void schedule(Runnable event, long delay) {
        scheduler.schedule(event, delay, TimeUnit.MILLISECONDS);
    }

    void repeat(Runnable event, long initialDelay, long period) {
        scheduler.scheduleAtFixedRate(event, initialDelay, period, TimeUnit.MILLISECONDS);
    }

    static class Repeat implements Runnable, Delayed {
        private int period;
        private long trigger;
        private Runnable runnable;
        private DelayQueue<Repeat> queue;

        public Repeat(Runnable runnable, int initialDelay, int period, DelayQueue<Repeat> queue) {
            this.runnable = runnable;
            this.period = period;
            this.queue = queue;
            trigger = System.nanoTime() + TimeUnit.NANOSECONDS.convert(initialDelay, TimeUnit.MILLISECONDS);
            queue.put(this);
        }

        @Override
        public void run() {
            try {
                while(!Thread.interrupted()) {
                    _run();
                }
            } catch(InterruptedException e) {
//                e.printStackTrace();
            }
        }

        private synchronized void _run() throws InterruptedException {
            queue.take().runnable.run();
            trigger = System.nanoTime() + TimeUnit.NANOSECONDS.convert(period, TimeUnit.MILLISECONDS);
            queue.put(this);
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(trigger - System.nanoTime(), TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return Long.compare(trigger, ((Repeat) o).trigger);
        }
    }

    //new feature: data collection
    static class DataPoint {
        final LocalDateTime dateTime;
        final float temperature;
        final float humidity;

        public DataPoint(LocalDateTime dateTime, float temperature, float humidity) {
            this.dateTime = dateTime;
            this.temperature = temperature;
            this.humidity = humidity;
        }

        @Override
        public String toString() {
            return dateTime +
                    String.format(
                            " temperature: %1$.1f humidity: %2$.2f",
                            temperature, humidity);
        }
    }

    class LightOn implements Runnable {
        @Override
        public void run() {
            System.out.println("Turning light on");
            light = true;
        }
    }

    class LightOff implements Runnable {
        @Override
        public void run() {
            System.out.println("Turning light off");
            light = false;
        }
    }

    class WaterOn implements Runnable {
        @Override
        public void run() {
            System.out.println("Water on");
            water = true;
        }
    }

    class WaterOff implements Runnable {
        @Override
        public void run() {
            System.out.println("Water off");
            water = false;
        }
    }

    class ThermostatNight implements Runnable {
        @Override
        public void run() {
            System.out.println("Thermostat to night settings");
            setThermostat("Night");
        }
    }

    class ThermostatDay implements Runnable {
        @Override
        public void run() {
            System.out.println("Thermostat to day settings");
            setThermostat("Day");
        }
    }

    class Bell implements Runnable {
        @Override
        public void run() {
            System.out.println("Bing!");
        }
    }

    class Terminate implements Runnable {
        @Override
        public void run() {
            System.out.println("\n\n\n\n Terminating");
            scheduler.shutdownNow();
            /**
             * Must start a separate task to do this job
             * since the scheduler has been shut down
             */
            new Thread() {
                @Override
                public void run() {
                    for(DataPoint d : data) {
                        System.out.println(d);
                    }
                }
            }.start();
        }
    }

    class TerminateDelay implements Runnable {
        @Override
        public void run() {
            System.out.println("\n\n\n\n Terminating");
            exec.shutdownNow();
            /**
             * Must start a separate task to do this job
             * since the scheduler has been shut down
             */
            new Thread() {
                @Override
                public void run() {
                    for(DataPoint d : data) {
                        System.out.println(d);
                    }
                }
            }.start();
        }
    }

    class CollectionData implements Runnable {
        @Override
        public void run() {
            System.out.println("CollectingData");
            synchronized(GreenHouseScheduler.this) {
                //pretend the interval is longer than it is
                lastTime = lastTime.plus(30, ChronoUnit.MINUTES);
                //one in 5 chances of reversing the direction
                if(rand.nextInt(5) == 4) {
                    tempDirection = -tempDirection;
                }
                lastTemp = lastTemp + tempDirection * (1.0f + rand.nextFloat());
                if(rand.nextInt(5) == 4) {
                    humidityDirection = -humidityDirection;
                }
                lastHumidity = lastHumidity + humidityDirection * rand.nextFloat();

                data.add(new DataPoint(LocalDateTime.of(lastTime.toLocalDate(), lastTime.toLocalTime()), lastTemp, lastHumidity));
            }

        }
    }


}
