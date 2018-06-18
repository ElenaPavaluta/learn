package oc.p.chapters._4_FunctionalProgramming.usingStreams.usingCommonTerminalOperations.reduce.tw;

import utils.resources.files.Resources;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

/**
 * T reduce(T identity, BinaryOperator<T> accumulator)
 *
 * Performs a reduction on the elements of this stream,
 * using the provided identity value and an associative accumulation function,
 * and returns the reduced value.
 */
class R {
    Path path = Paths.get(Resources.SRC_MAIN_JAVA);

    public static void main(String[] args) throws IOException {
        R r = new R();

//        r.m();
//        r.m2();
//        r.m3();
        r.m4();
    }

    Stream<Path> init() throws IOException {
        return Files.walk(path);
    }

    void m() throws IOException {
        long l = init().count();
        System.out.println(l);
    }

    void m2() throws IOException {
        long l2 = init()
                .filter(p -> p.getFileName().toString().equals("A.java"))
                .map(p -> {
                    try {
                        return Files.lines(p).count();
                    } catch(IOException e) {
                        e.printStackTrace();
                    }
                    return 0l;
                })
                .reduce(1l, (x, y) -> Long.sum(x, y));
        System.out.println(l2);
    }

    void m3() throws IOException {
        init()
                .filter(this::modifiedThisMonth)
                .collect(groupingBy(this::getDayOfMonth))
                .forEach((k, v) -> System.out.println(k + " -> " + v.size()));
    }

    private boolean modifiedThisMonth(Path p) {
        try {
            return Files.getLastModifiedTime(p).toInstant().isAfter(Instant.now().minus(LocalDate.now()
                                                                                                 .getDayOfMonth() -
                                                                                                1, ChronoUnit.DAYS));
        } catch(IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Integer getDayOfMonth(Path p) {
        try {
            return LocalDateTime.ofInstant(Files.getLastModifiedTime(p).toInstant(), ZoneId.systemDefault())
                                .getDayOfMonth();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    void m4() throws IOException {
        long l = init()
                .filter(this::modifiedThisMonth)
                .map(p -> {
                    try {
                        return Files.size(p);
                    } catch(IOException e) {
                        e.printStackTrace();
                    }
                    return 0l;
                })
                .reduce(0l, (p, p2)-> Long.sum(p, p2));
        System.out.println(l);
    }

}
