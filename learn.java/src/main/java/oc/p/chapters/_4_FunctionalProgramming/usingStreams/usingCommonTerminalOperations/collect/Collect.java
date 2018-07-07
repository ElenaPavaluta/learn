package oc.p.chapters._4_FunctionalProgramming.usingStreams.usingCommonTerminalOperations.collect;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <R> R	collect(Supplier<R> supplier, BiConsumer<R, T> accumulator, BiConsumer<R,R> combiner)
 * Performs a mutable reduction operation on the elements of this stream.
 *
 * <R,A> R	collect(Collector<? super T,A,R> collector)
 * Performs a mutable reduction operation on the elements of this stream using a Collector.
 *
 *
 * infinite stream: does not terminate
 * reduce: yes
 *
 * The collect() method is a special dbType of reduction called a mutable reduction. It is
 * more efficient than a regular reduction because we use the same mutable object while
 * accumulating. Common mutable objects include StringBuilder and ArrayList.
 */
class Collect {

    static Stream<String> stream;

    static void initStream() {
        stream = Arrays.asList("w", "o", "l", "f").stream();
    }

    /*
        The first parameter is a Supplier that creates the object that will store the results as we
    collect data.
        The second parameter is a BiConsumer. It is responsible for adding one more element to the data collection.
    It appends the next String to the StringBuilder.
        The final parameter is another BiConsumer. It is responsible for taking two data collections
    and merging them. This is useful when we are processing in parallel. Two smaller
    collections are formed and then merged into one. This would work with StringBuilder
    only if we didn’t care about the order of the letters. In this case, the accumulator and combiner have similar logic.
     */
    static void m() {
        initStream();
        StringBuilder stringBuilder = stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(stringBuilder.toString());
    }

    static void m2() {
        initStream();
        String s = stream.collect(String::new, String::concat, String::concat);
        System.out.println(s); // doesn't print anything. why?
    }

    static void m3() {
        initStream();
        TreeSet<String> set = stream.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        System.out.println(set);
    }

    static void m4() {
        initStream();
        TreeSet<String> treeSet = stream.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(treeSet);

        initStream();
        Set<String> set = stream.collect(Collectors.toSet());
        System.out.println(set);
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
        m4();
    }

}
