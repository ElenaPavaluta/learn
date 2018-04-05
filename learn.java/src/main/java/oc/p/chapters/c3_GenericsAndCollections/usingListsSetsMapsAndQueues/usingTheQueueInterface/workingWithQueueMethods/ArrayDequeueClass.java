package oc.p.chapters.c3_GenericsAndCollections.usingListsSetsMapsAndQueues.usingTheQueueInterface.workingWithQueueMethods;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ArrayDequeueClass {

    private static Queue<String> queuue = Stream.iterate("a", "a"::concat)
                                                .limit(10)
                                                .collect(Collectors.toCollection(ArrayDeque::new));


    static void queue(){
        System.out.println(queuue);
        System.out.println(queuue.size());  //10
        queuue.clear();

        System.out.println(queuue.add("b"));
        System.out.println(queuue.add("b"));
        System.out.println(queuue);
        System.out.println("allows duplicate \n");

//        System.out.println(queuue.add(null));
//        System.out.println(queuue.add(null));
        System.out.println(queuue);
        System.out.println("doesn't allows null");

        System.out.println(queuue.remove("a"));  //false
        System.out.println(queuue.remove("b")); //true
        System.out.println(queuue.add("a"));  //true
        System.out.println(queuue.add("c"));  //true
        System.out.println(queuue.add("d"));  //true
        System.out.println(queuue);  //[b, a, c, d]

        System.out.println(queuue.offer("e"));  //true
        System.out.println(queuue.offer("f"));  //true
        System.out.println(queuue);  //[b, a, c, d, e, f]


    }

    public static void main(String[] args) {
        queue();
    }
}
