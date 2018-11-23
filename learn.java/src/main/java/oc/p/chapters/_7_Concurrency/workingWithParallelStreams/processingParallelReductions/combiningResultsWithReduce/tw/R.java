package oc.p.chapters._7_Concurrency.workingWithParallelStreams.processingParallelReductions.combiningResultsWithReduce.tw;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

/**
 * <T> R reduce(R identity, BiFunction<R, T, R> accumulator, BinaryOperator<R, R, R> combiner)
 *
 * Rules for concurrent reduction
 *
 * combiner(identity, r) -> r;
 *
 * accumulator(a, accumulator(b, c)) == accumulator(accumulator(a, b), c)
 *
 * accumulator(r, t) == combiner(r, accumulator(identity, t))
 */
class R {
    static final BiFunction <Long, Integer, Long> BI_FUNCTION = (l, i) -> Long.sum(l, i.intValue());
    static final BinaryOperator <Long> BINARY_OPERATOR = Long::sum;

    static Long identity = 0l;
    static Long a = 1l;
    static Integer b = 2;
    static Integer c = 3;

    static void m() {
        final Long reduce = IntStream.rangeClosed(1, 100)
                .mapToObj(Integer::new)
                .reduce(new Long(0),
                        BI_FUNCTION,
                        BINARY_OPERATOR);

        System.out.println(reduce);
    }

    static void m2(){

    }

    static void m3(){
        Long identity = 0l;
        Long a = 1l;
        Integer b = 2;


        final Long apply = BI_FUNCTION.apply(a, b);
        final Long apply2 = BINARY_OPERATOR.apply(a, BI_FUNCTION.apply(identity, b));

        System.out.println(apply);
        System.out.println(apply2);
    }

    public static void main(String[] args) {
//        m();
        m3();
    }
}
