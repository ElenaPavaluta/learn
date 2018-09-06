package oc.p.chapters._4_FunctionalProgramming.usingStreams.usingCommonTerminalOperations.collect.tw._2;

import utils.resources.files.Resources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * <U> U reduce(U identity,
 * BiFunction<U, ? super T, U> accumulator,
 * BinaryOperator<U> combiner);
 *
 * <R> R collect(Supplier<R> supplier,
 * BiConsumer<R, ? super T> accumulator,
 * BiConsumer<R, R> combiner);
 */
class ReduceVsCollect {

    static Predicate<FileTime> THIS_YEAR = ft -> {
        LocalDate ld = LocalDate.now();
        ld = ld.minusMonths(ld.getMonthValue());
        ld = ld.minusDays(ld.getDayOfMonth() - 1);
        LocalDate ldt = LocalDateTime.ofInstant(ft.toInstant(), ZoneId.systemDefault()).toLocalDate();
        return ld.isBefore(ldt);
    };

    static Path path = Paths.get(Resources.SRC_MAIN_JAVA);

    static void m() throws IOException {
        final Integer java = java()
//                .peek(System.out::println)
                .reduce(0, (i, p) -> i + 1, Integer::sum);
        System.out.println(java);
    }

    private static Stream<Path> java() throws IOException {
        return Files.walk(path)
                .filter(p -> p.endsWith("java"));
    }

    static void m2() throws IOException {
        final Nb collect = java()
                .map(p -> 1)
//                .peek(System.out::println)
                .collect(Nb::new, Nb::add, Nb::add);
        System.out.println(collect.getNb());
    }

    static void m3() throws IOException {
        final Integer reduce = thisYear()
                .reduce(0, (i, p) -> i + 1, Integer::sum);
        System.out.println(reduce);
    }

    private static Stream<Path> thisYear() throws IOException {
        return Files.find(path, Byte.MAX_VALUE, (p, bfa) -> THIS_YEAR.test(bfa.creationTime()));
    }

    static void m4() throws IOException {
        final Nb collect = thisYear()
                .collect(Nb::new, (i, p) -> i.add(1), Nb::add);
        System.out.println(collect.getNb());
    }

    static void m5() throws IOException {
        final Long reduce = thisYear()
                .filter(getPathPredicate())
                .map(getPathLongFunction())
                .reduce(0l, Long::sum, Long::sum);
        System.out.println(reduce);
    }

    private static Function<Path, Long> getPathLongFunction() {
        return p -> {
            try {
                return Files.lines(p)
                        .count();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return 0l;
        };
    }

    static void m6() throws IOException {
        final Nb collect = thisYear()
                .filter(getPathPredicate())
                .map(getPathLongFunction())
                .collect(Nb::new, (n, l) -> n.add(l.intValue()), Nb::add);
        System.out.println(collect.getNb());
    }

    private static Predicate<Path> getPathPredicate() {
        return p -> p.getName(p.getNameCount() - 1).toString().contains(".java");
    }

    public static void main(String[] args) throws IOException {
//        m();
//        m2();

//        m3();
//        m4();

        m5();
        m6();
    }
}

class Nb {

    private int nb;

    Nb() {
    }

    int getNb() {
        return nb;
    }

    void add(int i) {
        nb += i;
    }

    void add(Nb n) {
        this.nb = +n.nb;
    }
}
