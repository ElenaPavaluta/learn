package oc.p.chapters._4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.collectors.groupingBy.tw;

import oc.p.chapters._9_NIO2.util.TestPath;
import utils.delimitators.Delimitators;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

class GroupingBy2 {

    static Function<Path, LocalDate> PATH_TO_LOCAL_DATE = p -> {
        try {
            return LocalDateTime.ofInstant(Files.readAttributes(p, BasicFileAttributes.class).creationTime()
                                                .toInstant(),
                                           ZoneOffset.systemDefault()).toLocalDate();
        } catch(IOException e) {
            return LocalDate.now();
        }
    };


    static Function<Path, Year> PATH_TO_YEAR = p -> Year.of(PATH_TO_LOCAL_DATE.apply(p).getYear());
    static Function<Path, Month> PATH_TO_MONTH = p -> PATH_TO_LOCAL_DATE.apply(p).getMonth();
    static Function<Path, Integer> PATH_TO_DAY_OF_MONTH = p -> PATH_TO_LOCAL_DATE.apply(p).getDayOfMonth();
    static Function<Path, DayOfWeek> PATH_TO_DAY = p -> PATH_TO_LOCAL_DATE.apply(p).getDayOfWeek();
    static Function<Path, String> PATH_TO_STRING = p -> p.getFileName().toString();
    static Function<Path, Character> PATH_TO_CHAR = p -> PATH_TO_STRING.apply(p).charAt(0);

    static void m() {
        Map<LocalDate, Map<Character, List<String>>> map = TestPath.pathsThisMonth().limit(100)
                                                                   .collect(groupingBy(PATH_TO_LOCAL_DATE,
                                                                                       Collectors.mapping(p -> (
                                                                                                                  (Path) p).getFileName
                                                                                                                  ()
                                                                                                                           .toString(),
                                                                                                          groupingBy
                                                                                                                  (s -> ((String) s).charAt(0)))));
        map.forEach((k, v) -> {
            System.out.println(k + "->");
            v.forEach((k2, v2) -> System.out.println("    " + k2 + "---> " + v2));
            Delimitators.equal();
        });
    }

    static void m2() {
        Map<Year, Map<Month, Map<DayOfWeek, List<String>>>> map
                = TestPath.allPaths()
                          .collect(groupingBy(PATH_TO_YEAR,
                                              groupingBy(PATH_TO_MONTH,
                                                         groupingBy(PATH_TO_DAY,
                                                                    Collectors.mapping(p -> p.getFileName().toString
                                                                            (), toList())))));
        print3LevelMap(map);
    }

    private static void print3LevelMap(Map<Year, Map<Month, Map<DayOfWeek, List<String>>>> map) {
        map.forEach((k, v) -> {
            System.out.println(k + "-> ");
            v.forEach((k2, v2) -> {
                System.out.println("     " + k2 + "--> ");
                v2.forEach((k3, v3) -> {
                    System.out.println("          " + k3 + "--->" + v3);
                });
            });
            Delimitators.equal();
        });
    }

    static void m3() {
        Map<Year, Map<Month, Map<Integer, Map<Character, List<String>>>>> map
                = TestPath.allPaths()
                          .collect(
                                  groupingBy(PATH_TO_YEAR,
                                             groupingBy(PATH_TO_MONTH,
                                                        groupingBy(PATH_TO_DAY_OF_MONTH,
                                                                   groupingBy(PATH_TO_CHAR,
                                                                              mapping(PATH_TO_STRING, toList
                                                                                      ()))))));
        map.forEach((k, v) -> {
            System.out.println(k + "-> ");
            v.forEach((k2, v2) -> {
                System.out.println("     " + k2 + "--> ");
                v2.forEach((k3, v3) -> {
                    System.out.println("          " + k3 + "--->");
                    v3.forEach((k4, v4) -> {
                        System.out.println("               " + k4 + "----> " + v4);
                    });
                });
            });
            Delimitators.equal();
        });
    }

    static void m4() {
        Map<Year, TreeMap<Month, TreeMap<Integer, List<String>>>> map
                = TestPath.allPaths().collect(groupingBy(PATH_TO_YEAR, TreeMap::new,
                                                         groupingBy(PATH_TO_MONTH, TreeMap::new,
                                                                    groupingBy(PATH_TO_DAY_OF_MONTH, TreeMap::new,
                                                                               mapping(PATH_TO_STRING, toList())))));
        map.forEach((k, v) -> {
            System.out.println(k + "-> ");
            v.forEach((k2, v2) -> {
                System.out.println("     " + k2 + "--> ");
                v2.forEach((k3, v3) -> {
                    System.out.println("          " + k3 + "--->" + v3);
                });
            });
            Delimitators.equal();
        });
    }


    public static void main(String[] args) {
//        createAndPopulate();
//        m2();
//        m3();
        m4();
    }
}
