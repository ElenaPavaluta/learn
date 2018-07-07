package oc.p.chapters._4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.collectors
        .toMap.tw;


import oc.p.chapters._9_NIO2.util.TestPath;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

class TM {

    static Function<Path, Instant> PATH_TO_INSTANT = p -> {
        try {
            return Files.readAttributes(p, BasicFileAttributes.class).creationTime().toInstant();
        } catch(IOException e) {
            return null;
        }
    };

    static Function<Path, String> PATH_TO_STRING = p -> p.getFileName().toString();

    static BinaryOperator<String> MERGE = (a, b) -> a + ", " + b + ", ";

    static void m() {
        TestPath.pathsThisMonth().collect(toMap(PATH_TO_INSTANT, PATH_TO_STRING, MERGE)).forEach((k, v) -> System
                .out.println(k + " -> " + v));
    }

    static void m2(){
        TestPath.pathsThisMonth().collect(toMap(PATH_TO_INSTANT, PATH_TO_STRING, MERGE, TreeMap::new)).forEach((k, v)-> System.out.println(k + " -> " +v));
    }

    public static void main(String[] args) {
//        createAndPopulate();
        m2();
    }
}
