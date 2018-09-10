package oc.p.chapters._4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.chainingOptionals.tw._1;

import java.time.LocalDateTime;
import java.util.Optional;

class Filter {

//    static Optional<LocalDateTime> opt = Optional.of(LocalDateTime::now);  //compiler error: T is not a functional interface
    static Optional<LocalDateTime> opt= Optional.of(LocalDateTime.now());

    static void m(){
        final Optional<LocalDateTime> optional = opt.filter(ldt -> ldt.isBefore(LocalDateTime.now()));
        System.out.println(optional);
    }

    static void m2(){
        final Optional<LocalDateTime> localDateTime = opt.filter(l -> l.isAfter(LocalDateTime.now()));
        System.out.println(localDateTime);
    }

    public static void main(String[] args) {
        System.out.println(opt);

//        m();
        m2();
    }
}
