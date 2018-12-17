package oc.p.chapters._4_FunctionalProgramming.usingStreams.usingCommonTerminalOperations.collect.tw._1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static utils.resources.files.Resources.SRC_MAIN_JAVA;
import static utils.resources.files.Separation.SLASH;

/**
 * <R> R  collect(Supplier<R> supplier, BiConsumer<R, T> accumulator, BiConsumer<R,R> combiner)
 * Performs a mutable reduction operation on the elements of this stream.
 */
class C2 {
    Path path = Paths.get(SLASH.separationOf(SRC_MAIN_JAVA));
    Instant today = Instant.now().minus(LocalTime.now().getHour(), ChronoUnit.HOURS);

    public static void main(String[] args) throws IOException {
        C2 c = new C2();
        c.m();
    }

    void m() throws IOException {
        A <Path> ap = Files.find(path, Byte.MAX_VALUE, (p, bfa) -> bfa.creationTime().toInstant().isAfter(today))
                .collect(A::new, (a, p) -> a.addElem(p), (a, a2) -> a2.forEach(a::addElem));

        ap.forEach(System.out::println);
    }
}

class A<T> extends ArrayList <T> {

    public boolean addElem(T t) {
        return super.add(t);
    }

    List <T> getAll() {
        return this;
    }
}
