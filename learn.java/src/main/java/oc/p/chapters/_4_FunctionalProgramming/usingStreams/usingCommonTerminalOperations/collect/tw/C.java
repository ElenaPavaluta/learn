package oc.p.chapters._4_FunctionalProgramming.usingStreams.usingCommonTerminalOperations.collect.tw;

import utils.resources.files.Resources;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * <R> R  collect(Supplier<R> supplier, BiConsumer<R, T> accumulator, BiConsumer<R,R> combiner)
 * Performs a mutable reduction operation on the elements of this stream.
 */
class C {
    Path path = Paths.get(Resources.SRC_MAIN_JAVA);
    Instant today = Instant.now().minus(LocalTime.now().getHour(), ChronoUnit.HOURS);
    void m() throws IOException {
        Coll coll = Files.find(path, Byte.MAX_VALUE, (p, bfa)->bfa.creationTime().toInstant().isAfter(today))
             .collect(()->new Coll(), (c, p)->c.add(p), (c, c2)->c2.forEach(p->c.add(p)));
        coll.forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        C c = new C();
        c.m();
    }
}


class Coll<T> extends ArrayList<T> implements  Supplier<Coll>, BiConsumer<Coll, T>/*, BiConsumer<R, R>*/{


    @Override
    public void accept(Coll coll, T t) {
        coll.add(t);
    }

    @Override
    public Coll get() {
        try {
            return this.getClass().newInstance();
        } catch(InstantiationException e) {
            e.printStackTrace();
        } catch(IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}