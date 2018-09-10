package oc.p.chapters._4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.chainingOptionals.tw._1;

import java.time.LocalDate;
import java.util.Optional;
import java.util.function.Function;

class FlatMap {

    static Optional<Optional<LocalDate>> opt = Optional.of(Optional.of(LocalDate.now()));

    static void m(){
        final Optional<LocalDate> date = opt.flatMap(o -> o.map(Function.identity()));
        System.out.println(date);
    }

    static void m2(){
        Optional<LocalDate> old = opt.get();
        System.out.println(old);

        final Optional<LocalDate> localDate = old.map(Function.identity());
        System.out.println(localDate);
    }

    static void m3(){
        final Optional<LocalDate> localDate = opt.flatMap(o -> o);
        System.out.println(localDate);
    }

    public static void main(String[] args) {
        System.out.println(opt);

//        m();
//        m2();
        m3();
    }

}
