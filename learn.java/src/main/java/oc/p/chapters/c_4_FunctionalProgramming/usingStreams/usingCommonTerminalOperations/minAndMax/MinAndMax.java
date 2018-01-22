package oc.p.chapters.c_4_FunctionalProgramming.usingStreams.usingCommonTerminalOperations.minAndMax;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * Optional<T>	min(Comparator<? super T> comparator)
 *
 * Optional<T>	max(Comparator<? super T> comparator)
 *
 * infinite stream: does not terminate
 *
 * reduce: yes
 */
class MinAndMax {

    static Comparator<G> comparator;

    static MinAndMax mm = new MinAndMax();
    static Stream<G> stream = Stream.<G>of(mm.new G("a"), mm.new G("c"), mm.new G("b"));

    static {
        comparator = (g, g2) -> Integer.compare(g.name.length(), g2.name.length());
//        comparator = Integer::compare;  //compiler error due to the fact, that I need to call name.length
    }

    static void min() {
        Optional<G> optional = stream.min(comparator);
        optional.ifPresent(System.out::println);
    }

    static void minInfinite() {
        Stream<Integer> stream = Stream.iterate(1, new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer + 1;
            }
        });
        stream.forEach(System.out::println);
    }

    static void max() {
        Optional<G> optional = stream.max(comparator);
        System.out.println(optional.orElse(mm.new G("d")).name);
    }

    public static void main(String[] args) {
//        min();
//        minInfinite();
        max();
    }

    class G {
        String name;

        public G(String name) {
            this.name = name;
        }
    }
}
