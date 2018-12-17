package oc.p.chapters._4_FunctionalProgramming.usingStreams.usingCommonTerminalOperations.reduce.tw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import static utils.resources.files.Resources.SRC_MAIN_JAVA;
import static utils.resources.files.Separation.SLASH;

/**
 * <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
 *
 * Performs a reduction on the elements of this stream,
 * using the provided identity, accumulation and combining functions.
 */
class R3 {

    Path path = Paths.get(SLASH.separationOf(SRC_MAIN_JAVA));
    Predicate <Path> JPG_PREDICATE = p -> {
        String s = p.getFileName().toString();
        return s.contains(".jpg") || s.contains(".jpeg");
    };
    List <Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');

    public static void main(String[] args) throws IOException {
        R3 r = new R3();
        r.m();
        r.m2();
        r.m3();
        r.m4();
        r.m5();
        r.m6();
    }

    //how many lines of codes does this project has
    void m() throws IOException {
        long l = Files
                .walk(path)
                .filter(p -> p.getFileName().toString().contains(".java"))
                .reduce(0l, (i, p) -> {
                    try {
                        return Long.sum(i, Files.lines(p).count());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return 0l;
                }, Long::sum);
        System.out.println(l);
    }

    //how many non java file it has
    void m2() throws IOException {
        long l = Files.walk(path).filter(JPG_PREDICATE::test).reduce(0l, (i, p) -> Long.sum(i, 1), Long::sum);
        System.out.println(l);
    }

    void m3() throws IOException {
        int count = Files.walk(path).reduce(0, integerPathIntegerBiFunction(), Integer::sum);
        System.out.println(count);
    }

    private BiFunction <Integer, Path, Integer> integerPathIntegerBiFunction() {
        return (i, p) -> Files.isDirectory(p) ? Integer.sum(i, 1) : i;
    }

    void m4() throws IOException {
        int count = Files.find(path, Byte.MAX_VALUE, (p, bfa) -> bfa.isDirectory())
                .reduce(0,
                        (i, p) -> p.getFileName().toString().contains("a") ? Integer.sum(i, 1) : i,
                        Integer::sum);
        System.out.println(count);
    }

    void m5() throws IOException {
        long count = Files.find(path, Byte.MAX_VALUE, (p, bfa) -> bfa.isDirectory())
                .reduce(0l, (i, p) -> Long.sum(i, p.getFileName().toString().length()), Long::sum);
        System.out.println("number of chars in dirs : " + count);
    }

    void m6() throws IOException {
        long count = Files.find(path, Byte.MAX_VALUE, (p, bfa) -> bfa.isDirectory())
                .reduce(0l, (i, p) -> Long.sum(i, nbOfV(p)), Long::sum);
        System.out.println("number of vowels: " + count);
    }

    private int nbOfV(Path p) {
        String s = path.getFileName().toString();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                count++;
            }
        }

        return count;
    }
}
