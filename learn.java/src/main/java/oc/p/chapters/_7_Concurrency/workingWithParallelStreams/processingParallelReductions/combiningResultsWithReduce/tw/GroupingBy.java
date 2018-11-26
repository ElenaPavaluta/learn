package oc.p.chapters._7_Concurrency.workingWithParallelStreams.processingParallelReductions.combiningResultsWithReduce.tw;

import utils.delimitators.Delimitators;
import utils.resources.files.ResourcesData;
import utils.resources.files.ResourcesPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.*;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;


class GroupingBy {

    static Path path = ResourcesPath.SRC_MAIN_JAVA.get();
    static Instant thisYear = ResourcesData.THIS_YEAR.instant();
    static Instant thisMonth = ResourcesData.THIS_MONTH.instant();

    static {
        System.out.println(path);
        System.out.println(thisYear);
        System.out.println(thisMonth);
        Delimitators.equal();
    }

    static void m() throws IOException {
        final Map <Month, Long> map = Files.find(path, Byte.MAX_VALUE, (p, bfa) -> bfa.creationTime().toInstant().isAfter(thisYear) && bfa.isRegularFile())
                .collect(groupingBy(p -> {
                    try {
                        BasicFileAttributes bfa = Files.readAttributes(p, BasicFileAttributes.class);
                        Instant instant = bfa.creationTime().toInstant();
                        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).getMonth();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return Month.DECEMBER;
                }, counting()));

        System.out.println(map);
    }

    static void m2() throws IOException {
        final Map <Integer, Long> map = Files.find(path, Byte.MAX_VALUE, (p, bfa) -> bfa.creationTime().toInstant().isAfter(thisMonth))
                .collect(groupingBy(p -> {
                    try {
                        BasicFileAttributes bfa = Files.readAttributes(p, BasicFileAttributes.class);
                        return LocalDateTime.ofInstant(bfa.creationTime().toInstant(), ZoneId.systemDefault()).getDayOfMonth();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return 31;
                }, counting()));
        System.out.println(map);
    }

    public static void main(String[] args) throws IOException {
//        m();
        m2();
    }
}