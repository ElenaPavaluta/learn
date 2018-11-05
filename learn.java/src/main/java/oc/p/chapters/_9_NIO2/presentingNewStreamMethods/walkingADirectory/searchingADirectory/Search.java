package oc.p.chapters._9_NIO2.presentingNewStreamMethods.walkingADirectory.searchingADirectory;

import utils.resources.files.Resources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Return a Stream that is lazily populated with Path by searching for files in a file tree rooted at a given
 * starting file.
 *
 * The file tree is traversed depth-first
 *
 * static Stream<Path>	find(Path start, int maxDepth, BiPredicate<Path,BasicFileAttributes> matcher, FileVisitOption... options)
 */
class Search {
    Path path = Paths.get(Resources.SRC_MAIN_JAVA);

    public static void main(String[] args) {
        Search s = new Search();
//        s.m();
        s.m2();
    }

    void m() {

        try {
            Stream <Path> stream = Files.find(path, Byte.MAX_VALUE, (p, bfa) -> bfa.isDirectory());
            System.out.println(stream.count());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void m2() {
        Instant yearStart = Instant.now().minus(LocalDate.now().getDayOfYear() - 1, ChronoUnit.DAYS);
        System.out.println(yearStart);
        FileTime fileTime = FileTime.from(yearStart);

        try {
            Files
                    .find(path, Byte.MAX_VALUE, (p, bfa) ->
                            bfa.isDirectory() &&
                                    bfa.creationTime().toInstant().isAfter(yearStart))
                    .collect(Collectors.groupingBy(p -> {
                        try {
                            return LocalDateTime.ofInstant(Files.readAttributes(p, BasicFileAttributes.class)
                                            .creationTime()
                                            .toInstant(),
                                    ZoneId.systemDefault()).getMonth();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return null;
                    })).forEach((m, lp) -> System.out.println(m + " -> " + lp.size()));
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}
