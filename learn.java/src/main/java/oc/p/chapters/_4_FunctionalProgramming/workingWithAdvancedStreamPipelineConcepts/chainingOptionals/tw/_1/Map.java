package oc.p.chapters._4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.chainingOptionals.tw._1;

import java.util.Optional;

class Map {
    static Optional<Optional<Integer>> opt = Optional.of(Optional.of(007));


    static void m() {
        final Optional<Optional<String>> o2 = opt.map(o -> o.map(i -> "String: " + String.valueOf(i)));
        System.out.println(o2);
    }

    static void m2(){
        final Optional<Object> o1 = opt.map(o -> null);
        System.out.println(o1);
    }

    public static void main(String[] args) {
        System.out.println(opt);

//        m();
        m2();
    }
}
