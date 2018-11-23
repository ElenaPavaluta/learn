package oc.p.chapters._7_Concurrency.synchronizeDataAccess.tw._3;

import java.time.LocalTime;

class Pair {

    private State state;
    private LocalTime time;

    Pair(final State state, final LocalTime time) {
        this.state = state;
        this.time = time;
    }

    @Override
    public String toString() {
        return state.name();
    }
}
