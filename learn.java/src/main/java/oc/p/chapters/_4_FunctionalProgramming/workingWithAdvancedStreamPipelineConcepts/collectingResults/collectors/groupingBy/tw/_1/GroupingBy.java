package oc.p.chapters._4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.collectors.groupingBy.tw._1;

import oc.p.chapters._9_NIO2.util.TestPath;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * static <T,K> Collector<T,?,Map<K,List<T>>>
 *     groupingBy(Function<? super T,? extends K> classifier)
 * Returns a Collector implementing a "group by" operation on input elements of dbType T, grouping elements according
 * to a classification function, and returning the results in a Map.
 *
 *
 * static <T,K,A,D> Collector<T,?,Map<K,D>>
 *     groupingBy(Function<? super T,? extends K> classifier,
 *                Collector<? superT,A,D> downstream)
 * Returns a Collector implementing a cascaded "group by" operation on input elements of dbType T, grouping elements
 * according to a classification function, and then performing a reduction operation on the values associated with a
 * given key using the specified downstream Collector.
 *
 *
 * static <T,K,D,A,M extends Map<K,D>> Collector<T,?,M>
 *     groupingBy(Function<? super T,? extends K> classifier,
 *                          Supplier<M> mapFactory,
 *                          Collector<? superT,A,D> downstream)
 * Returns a Collector implementing a cascaded "group by" operation on input elements of dbType T, grouping elements
 * according to a classification function, and then performing a reduction operation on the values associated with a
 * given key using the specified downstream Collector.
 */
class GroupingBy {

    static void m() {
        Map<LocalDate, List<Path>> map =  TestPath.pathsThisYear().limit(100).collect(Collectors.groupingBy(pathLocalDateFunction()));
        map.forEach((k, v)-> System.out.println(k + " -> " + v));
    }

    private static Function<Path, LocalDate> pathLocalDateFunction() {
        return p-> {
            try {
                BasicFileAttributes bfa = Files.readAttributes(p, BasicFileAttributes.class);
                return LocalDateTime.ofInstant(bfa.creationTime().toInstant(), ZoneId.systemDefault()).toLocalDate();
            } catch(IOException e) {
                return LocalDate.now();
            }
        };
    }

    static void m2(){
        Map<LocalDate, Set<String>> map = TestPath.pathsThisMonth().limit(100)
                                                  .collect(Collectors.groupingBy(pathLocalDateFunction(),
                                               Collectors.mapping(p->p.getFileName().toString(), Collectors.toSet())));
        map.forEach((k, v)-> System.out.println(k + " -> " + v));
    }

    static void m3(){
        TreeMap<LocalDate, List<String>> map = TestPath.pathsThisMonth().limit(100)
                                         .collect(Collectors.groupingBy(pathLocalDateFunction(),
                                               TreeMap::new,
                                               Collectors.mapping(p->p.getFileName().toString(), Collectors.toList())));
        map.forEach((k, v)-> System.out.println(k + " -> " + v));
    }

    static void m4(){

    }

    public static void main(String[] args) {
//        m();
//        m2();
        m3();
    }
}
