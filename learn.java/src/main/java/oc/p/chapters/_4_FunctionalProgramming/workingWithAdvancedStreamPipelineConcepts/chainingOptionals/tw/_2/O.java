package oc.p.chapters._4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.chainingOptionals.tw._2;

import utils.delimitators.Delimitators;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

class O {

    static Optional <Integer> EMPTY = Optional.empty();
    static Optional <Integer> OF_NULLABLE_NULL = Optional.ofNullable(null);
    static Optional <Integer> OF_NULLABLE_NOT_NULL = Optional.ofNullable(007);
    static Optional <Integer> OPT = Optional.of(9);

    static List <Optional <Integer>> list = Arrays.asList(EMPTY, OF_NULLABLE_NULL, OF_NULLABLE_NOT_NULL, OPT);

    static void isPresent() {
        list.forEach(o -> System.out.println(o.isPresent()));
    }

    static void filter() {
        Predicate <Integer> predicate = i -> i >= 8;
        list.stream()
                .map(o -> o.filter(predicate))
//                .peek(System.out::println)
                .filter(Optional::isPresent)
                .forEach(System.out::println);
    }

    static void map() {
        Function <Integer, String> function = i -> "String: " + i;
        list.stream()
                .map(o -> o.map(function))
//                .filter(Optional::isPresent)
                .forEach(System.out::println);
    }

    static void flatMap() {
        final Function <? super Optional <Integer>, Optional <String>> function = o -> Optional.ofNullable("String: " + (o.isPresent() ? o.get() : "none"));
        List <Optional <String>> collect = list.stream()
                .map(Optional::ofNullable)
                .peek(System.out::println)
                .map(o -> o.flatMap(function))
                .collect(toList());
        Delimitators.equal();
        collect.forEach(System.out::println);
    }

    static void flatMap2() {
        List <Optional <Integer>> collect = list.stream()
                .map(Optional::ofNullable)
                .map(o -> o.flatMap(Function.identity()))
                .collect(toList());
        collect.forEach(System.out::println);
    }

    static void flatMap3() {
        List <Optional <Optional <Optional <Optional <Integer>>>>> collect = list.stream()
                .map(Optional::ofNullable)
                .map(Optional::ofNullable)
                .map(Optional::ofNullable)
                .collect(toList());
        collect.forEach(System.out::println);
        Delimitators.equal();

        List <Optional <Integer>> collect2 = collect.stream()
                .map(o -> o.flatMap(Function.identity()))
                .map(o -> o.flatMap(Function.identity()))
                .map(o -> o.flatMap(Function.identity()))
                .collect(toList());
        collect2.forEach(System.out::println);
    }

    public static void main(String[] args) {
//        isPresent();
//        filter();
//        map();
//        flatMap();
//        flatMap2();
        flatMap3();
    }


}
