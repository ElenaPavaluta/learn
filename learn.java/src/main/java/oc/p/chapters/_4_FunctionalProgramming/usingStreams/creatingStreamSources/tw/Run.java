package oc.p.chapters._4_FunctionalProgramming.usingStreams.creatingStreamSources.tw;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.toList;

class Run {

    static void m(){
//        List<Integer> lst = null;
        List<Integer> lst = new ArrayList<>();

        final List<Integer> collect = lst.stream()
                .map(i -> i*2)
                .collect(toList());
        System.out.println(collect);
        System.out.println(collect.size());
    }

    public static void main(String[] args) {
        m();
    }
}
