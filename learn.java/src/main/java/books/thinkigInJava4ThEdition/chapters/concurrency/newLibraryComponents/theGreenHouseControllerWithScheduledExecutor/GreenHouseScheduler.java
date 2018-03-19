package books.thinkigInJava4ThEdition.chapters.concurrency.newLibraryComponents.theGreenHouseControllerWithScheduledExecutor;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class GreenHouseScheduler {

    ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(10);
    //    ScheduledExecutorService ses = Executors.newScheduledThreadPool(20);
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



    public static void main(String[] args) {
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
                /**
                 * Calendar must be clones, otherwise all
                 * DataPoint-s hold references to the same larTime.
                 * for a basic object like Calendar, clone() is ok
                 */
                data.add(new DataPoint( LocalDateTime.of(lastTime.toLocalDate(), lastTime.toLocalTime()), lastTemp, lastHumidity));
            }

        }
    }


}
