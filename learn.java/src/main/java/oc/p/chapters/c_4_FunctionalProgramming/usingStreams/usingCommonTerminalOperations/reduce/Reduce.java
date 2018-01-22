package oc.p.chapters.c_4_FunctionalProgramming.usingStreams.usingCommonTerminalOperations.reduce;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * T reduce(T identity, BinaryOperator<T> accumulator)
 *              Performs a reduction on the elements of this stream,
 *              using the provided identity value and an associative accumulation function,
 *              and returns the reduced value.
 *
 * Optional<T> reduce(BinaryOperator<T> accumulator)
 *              Performs a reduction on the elements of this stream,
 *              using an associative accumulation function,
 *              and returns an Optional describing the reduced value, if any.
 *
 * <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
 *              Performs a reduction on the elements of this stream,
 *              using the provided identity, accumulation and combining functions.
 *
 * infinite stream: does not terminate
 *
 * reduce: yes
 */
class Reduce {

    static void m(){
        String[] arr  =new String []{"w", "o", "l", "f"};
        String res  = "";
        for(String s: arr){
            res +=s;
        }
        System.out.println(res);

        Stream<String> stream = Arrays.asList(arr).stream();

        res = stream.reduce("", String::concat);
        System.out.println(res);

        Optional<String> opt = stream.reduce(String::concat);
        opt.ifPresent(System.out::println);
    }

    static void m2(){
        Stream<Integer> stream = getStream();
        BinaryOperator<Integer> op = (n, n2) -> n*n2;


        int res = stream.reduce(1, op);
        System.out.println(res);

        stream = getStream();
        Optional<Integer> opt = stream.reduce(op);
        opt.ifPresent(System.out::println);

        stream  = getStream();
        res = stream.reduce(1, op, op);
        System.out.println(res);
    }

    private static Stream<Integer> getStream() {
        return Stream.of(3, 5, 6);
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
