package i.nespresso.tournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Fight {
    private Warrior one, other;
    private ExecutorService exec = null;

    public Fight(final Warrior one, final Warrior theOther) {
        this.one = one;
        this.other = theOther;
        exec = Executors.newCachedThreadPool();
    }

    void start() {
        while (bothWarriorsAlive()) {
            one.attack(exec, other);
            other.attack(exec, one);
        }
    }

    private boolean bothWarriorsAlive() {
        synchronized (one) {
            synchronized (other) {
                return one.isAlive() && other.isAlive();
            }
        }
    }
}
