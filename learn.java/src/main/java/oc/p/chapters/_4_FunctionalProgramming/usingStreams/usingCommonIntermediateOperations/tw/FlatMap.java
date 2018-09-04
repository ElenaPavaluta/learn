package oc.p.chapters._4_FunctionalProgramming.usingStreams.usingCommonIntermediateOperations.tw;

import utils.javaClass.hierrarchy.methods.alphabet.E;
import utils.javaClass.hierrarchy.methods.alphabet.F;

import java.util.*;
import java.util.stream.Stream;

/**
 * <R> Stream<R>	flatMap(Function<? super T,? extends Stream<? extends R>> mapper)
 * Returns a stream consisting of the results of replacing each element of this stream
 * with the contents of a mapped stream produced by applying the provided mapping
 * function to each element.
 */
class FlatMap {

    List<E> zero = Collections.EMPTY_LIST;
    List<E> one = Arrays.asList(new E());
    List<E> two = Arrays.asList(new E(), new F());
    AR<E> arZero = new AR<>(zero);
    AR<E> arOne = new AR<>(one);
    AR<E> arTwo = new AR<>(two);

    void m() {
        final Stream<E> stream = Stream.<List<E>>of(zero, one, two)
                .flatMap(List::stream);
    }

    void m2() {
        Stream<E> stream = Stream.<AR<E>>of(arZero, arOne, arTwo)
                .flatMap(ArrayList::stream);

        stream = Stream.<AR<E>>of(arZero, arOne, arTwo)
                .flatMap(List::stream);

        stream = Stream.<AR<E>>of(arZero, arOne, arTwo)
                .flatMap(Collection::stream);
    }

    class AR<T> extends ArrayList<T> {
        AR(final Collection<? extends T> c) {
            super(c);
        }
    }

//    void m(? extends AR<E> s){ }  //compiler error
}
