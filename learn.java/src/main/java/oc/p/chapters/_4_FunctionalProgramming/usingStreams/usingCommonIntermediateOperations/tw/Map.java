package oc.p.chapters._4_FunctionalProgramming.usingStreams.usingCommonIntermediateOperations.tw;

import utils.javaClass.hierrarchy.methods.alphabet.*;
import utils.print.Print;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * <R> Stream<R> map(Function<? super T, ? extends R> mapper)
 */
class Map {
    Function<C, String> C_TO_STRING = C::mC;
    Function<D, String> D_TO_STRING = D::md;
    Function<E, String> E_TO_STRING = E::mE;
    Function<F, String> F_TO_STRING = F::mF;

    List<E> lst = Arrays.asList(new E(), new F(), new G());

    public static void main(String[] args) {
        Map map = new Map();
        map.m2();
    }

    void m(final Function<? super E, ? extends String> func) {
        lst.stream()
                .map(func)
                .forEach(System.out::println);
    }

    void m2() {
        m(C_TO_STRING);
        Print.Delimitators.equal();

        m(D_TO_STRING);
        Print.Delimitators.equal();

        m(E_TO_STRING);
        Print.Delimitators.equal();

//        m(F_TO_STRING);  //Compiler error
    }
}
