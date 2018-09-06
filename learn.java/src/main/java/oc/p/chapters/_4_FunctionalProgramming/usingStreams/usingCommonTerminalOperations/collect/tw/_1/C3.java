package oc.p.chapters._4_FunctionalProgramming.usingStreams.usingCommonTerminalOperations.collect.tw._1;

import utils.delimitators.Delimitators;
import utils.resources.files.Resources;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * <R> R  collect(Supplier<R> supplier, BiConsumer<R, T> accumulator, BiConsumer<R,R> combiner)
 * Performs a mutable reduction operation on the elements of this stream.
 */
class C3 {
    Path path = Paths.get(Resources.SRC_MAIN_JAVA);
    Instant today = Instant.now().minus(LocalTime.now().getHour(), ChronoUnit.HOURS);

    public static void main(String[] args) throws IOException {
        C3 c = new C3();
        c.m();
        Delimitators.equal();
        c.m2();
        Delimitators.equal();
        c.m3();
    }

    Stream<Path> init() throws IOException {
        return Files.find(path, Byte.MAX_VALUE, (p, bfa) -> bfa.creationTime().toInstant().isAfter(today));
    }

    void m() throws IOException {
        init().collect(HashSet::new, HashSet::add, HashSet::addAll).forEach(System.out::println);
    }

    void m2() throws IOException {
        init().collect(ArrayDeque::new, ArrayDeque::push, ArrayDeque::addAll).forEach(System.out::println);
    }

    void m3() throws IOException {
        init().collect(Stack::new, Stack::add, Stack::addAll)
              .stream().filter(p->Files.isRegularFile((Path) p))
              .collect(Stack::new, Stack::add, Stack::addAll)
              .forEach(System.out::println);
    }
}
