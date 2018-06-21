package oc.p.chapters._4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.collectors.partitioningBy.tw;


import oc.p.chapters._9_NIO2.util.TestPath;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;

/**
 * static <T> Collector<T,?,Map<Boolean,List<T>>>	partitioningBy(Predicate<? super T> predicate)
 *
 * Returns a Collector which partitions the input elements according to a Predicate,
 * and organizes them into a Map<Boolean, List<T>>.
 *
 * static <T,D,A> Collector<T,?,Map<Boolean,D>>
 * partitioningBy(Predicate<? super T> predicate, Collector<? super T,A,D> downstream)
 *
 * Returns a Collector which partitions the input elements according to a Predicate,
 * reduces the values in each partition according to another Collector,
 * and organizes them into a Map<Boolean, D> whose values are the result of the downstream reduction.
 */
class P {

    static Function<Path, BasicFileAttributes> PATH_TO_BASIC_FILE_ATTRIBUTES = p -> {
        try {
            return Files.readAttributes(p, BasicFileAttributes.class);
        } catch(IOException e) {
            return null;
        }
    };

    static Predicate<Path> IS_REGULAR_FILE = p -> PATH_TO_BASIC_FILE_ATTRIBUTES.apply(p).isRegularFile();
    static Predicate<Path> IS_JAVA_FILE = p -> p.getFileName().toString().contains(".java");
    static Predicate<Path> IS_LARGER_THAN_50_b = p -> PATH_TO_BASIC_FILE_ATTRIBUTES.apply(p).size() > 50;
    static Function<Path, String> PATH_TO_STRING = p -> p.getFileName().toString();

    static void m() {
        Map<Boolean, Map<Boolean, Map<Boolean, List<String>>>> map
                = TestPath.pathsThisMonth()
                          .collect(partitioningBy(IS_REGULAR_FILE,
                                                  partitioningBy(IS_JAVA_FILE,
                                                                 partitioningBy(IS_LARGER_THAN_50_b, Collectors.mapping(PATH_TO_STRING, toList())))));

        map.forEach((k, v)->{
            System.out.println(k +" -> " );
            v.forEach((k2, v2)->{
                System.out.println("     " + k2 + " --> " );
                v2.forEach((k3, v3)->{
                    System.out.println("          " + k3 + "---> " + v3);
                });
            });
        });
    }

    public static void main(String[] args) {
        m();
    }
}
