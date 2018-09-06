package oc.p.chapters._4_FunctionalProgramming.usingStreams.usingCommonTerminalOperations.collect.tw._2;

import java.util.stream.Stream;

/**
 * <R> R reduce(R identity, BiFunction<R, U, R> acumulator, BinaryOperator<R> combiner)
 *
 * <R> R collect(Supplier<R>, BiConsumer(R, ? super U) acumulator, BiConsumer<R, R> combiner)
 */
class ReduceVsCollect_2 {

    static Stream<Integer> stream;

    static void init() {
        stream = Stream.<Integer>iterate(0, i -> i + 1).limit(50);
    }

    static void m() {
        init();
        final Integer reduce = stream.reduce(0, (n, old) -> n += old, Integer::sum);
        System.out.println(reduce);
    }

    static void m2() {
        init();
        final StringBuilder collect = stream
                .map(String::valueOf)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(collect);
    }

    public static void main(String[] args) {
        m();
        m2();
    }
}
