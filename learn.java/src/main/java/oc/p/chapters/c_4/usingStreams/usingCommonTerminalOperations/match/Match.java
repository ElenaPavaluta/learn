package oc.p.chapters.c_4.usingStreams.usingCommonTerminalOperations.match;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * boolean	noneMatch(Predicate<? super T> predicate)
 *          Returns whether no elements of this stream match the provided predicate.
 *
 * boolean	anyMatch(Predicate<? super T> predicate)
 *          Returns whether any elements of this stream match the provided predicate.
 *
 * boolean	allMatch(Predicate<? super T> predicate)
 *          Returns whether all elements of this stream match the provided predicate.
 *
 * infinite stream: sometimes terminates
 *
 * reduction:  no
 */
class Match {

    static Stream<Integer> infinite = Stream.iterate(new Integer(1), n -> n + 1);
    static Stream<Integer> finite = Stream.of(1, 2, 3);
    static Stream<Integer> empty = Stream.empty();
    static Predicate<Number> predicate = n->n.intValue()==2;

    static void noneMatch(){
        System.out.println(infinite.noneMatch(predicate));  //false; terminates,cause it finds a matching value
        System.out.println(finite.noneMatch(predicate));  //false;
        System.out.println(empty.noneMatch(predicate));  //true
    }

    static void anyMatch(){
        System.out.println(infinite.anyMatch(predicate));  //true
        System.out.println(finite.anyMatch(predicate)); //true
        System.out.println(empty.anyMatch(predicate));  //false
    }

    static void allMatch(){
        System.out.println(infinite.allMatch(predicate));  //false
        System.out.println(finite.allMatch(predicate));  //false
        System.out.println(empty.allMatch(predicate));  //true
    }

    public static void main(String[] args) {
//        noneMatch();
//        anyMatch();
        allMatch();
    }


}
