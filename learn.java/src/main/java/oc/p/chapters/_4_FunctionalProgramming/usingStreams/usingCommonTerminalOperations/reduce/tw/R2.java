package oc.p.chapters._4_FunctionalProgramming.usingStreams.usingCommonTerminalOperations.reduce.tw;

import utils.delimitators.Delimitators;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.BinaryOperator;

import static utils.resources.files.Resources.SRC_MAIN_JAVA;
import static utils.resources.files.Separation.SLASH;

/**
 * Optional<T> reduce(BinaryOperator<T> accumulator)
 * Performs a reduction on the elements of this stream,
 * using an associative accumulation function,
 * and returns an Optional describing the reduced value, if any.
 */
class R2 {
    Path path = Paths.get(SLASH.separationOf(SRC_MAIN_JAVA));

    Comparator <Path> comparator = Comparator.comparingLong(p -> lines(p));
    BinaryOperator <Path> maxBinaryOperator = BinaryOperator.maxBy(comparator);
    BinaryOperator <Path> minBinaryOperator = BinaryOperator.minBy(comparator);

    public static void main(String[] args) throws IOException {
        R2 r = new R2();
        r.m();
        r.m2();
        r.m3();
        Delimitators.equal();
//        r.m4();
        Delimitators.equal();
        r.m5();
    }

    private long lines(Path p) {
        try {
            return Files.size(p);
        } catch (IOException e) {
            return 0l;
        }
    }

    Path maxBy(Path p, Path p2) {
        return maxBinaryOperator.apply(p, p2);
    }

    void m() throws IOException {
        Optional <Path> optional = Files.walk(path).filter(Files::isRegularFile).reduce((p, p2) -> maxBinaryOperator
                .apply(p, p2));

        optional.ifPresent(System.out::println);
    }

    void m2() throws IOException {
        Files.walk(path).reduce((p, p2) -> maxBinaryOperator.apply(p, p2)).ifPresent(System.out::println);
    }

    void m3() throws IOException {
        Files.walk(path).reduce((p, p2) -> minBinaryOperator.apply(p, p2)).ifPresent(System.out::println);
    }

    void m4() throws IOException {
        Optional <Path> optional = Files.walk(path).filter(p -> p.getFileName().toString().contains(".java")).reduce
                (this::maxBy);

        optional.ifPresent(p -> {
            System.out.println(p);
            try {
                Files.lines(p).forEach(System.out::println);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    void m5() throws IOException {
        Optional <Path> optional = Files.walk(path).reduce(this::maxBy);
        optional.ifPresent(p -> {
            File f = p.toFile();
            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f))) {
                byte[] buff = new byte[256];
                int len;
                while ((len = bis.read(buff)) > 0) {
                    System.out.println(Arrays.toString(buff));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
