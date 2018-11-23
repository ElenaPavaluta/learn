package oc.p.chapters._7_Concurrency.synchronizeDataAccess.tw._3;

import java.time.LocalTime;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;

class Order {
    private State state = State.THIRD;

    private Integer id;
    private ConcurrentSkipListMap <Integer, CopyOnWriteArrayList <Pair>> map;

    Order(final int id, final ConcurrentSkipListMap <Integer, CopyOnWriteArrayList <Pair>> map) {
        this.id = id;
        this.map = map;
        map.computeIfAbsent(id, i -> new CopyOnWriteArrayList <>());
    }

    synchronized void one() throws InterruptedException {
        while (!state.readyForOne()) {
            wait();
        }
        state = State.ONE;
        Pair p = new Pair(state, LocalTime.now());
        put(p);
        notifyAll();
    }

    synchronized void two() throws InterruptedException {
        while (!state.readyForSecond()) {
            wait();
        }
        state = State.SECOND;
        Pair p = new Pair(state, LocalTime.now());
        put(p);
        notifyAll();
    }

    synchronized void third() throws InterruptedException {
        while (!state.readyForThird()) {
            wait();
        }
        state = State.THIRD;
        Pair p = new Pair(state, LocalTime.now());
        put(p);
        notifyAll();
    }

    private synchronized void put(final Pair p) {
        final CopyOnWriteArrayList <Pair> pairs = map.get(id);
        pairs.add(p);
        map.put(id, pairs);
    }

}
