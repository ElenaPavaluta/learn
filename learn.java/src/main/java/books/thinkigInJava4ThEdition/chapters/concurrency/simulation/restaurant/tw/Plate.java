package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant.tw;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

class Plate implements Delayed {

    private SingleCourse singleCourse;
    private long trigger;

    public Plate(SingleCourse singleCourse) {
        this.singleCourse = singleCourse;
        trigger = System.nanoTime() + TimeUnit.SECONDS.convert(singleCourse.prepareTime(), TimeUnit.MILLISECONDS);
    }

    public SingleCourse getSingleCourse() {
        return singleCourse;
    }

    @Override
    public String toString() {
        return singleCourse.dishName();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        Plate p = (Plate) o;
        return Long.compare(this.trigger, p.trigger);
    }


}
