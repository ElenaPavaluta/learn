package oc.p.chapters.c3_GenericsAndCollections.usingListsSetsMapsAndQueues.usingTheQueueInterface.workingWithQueueMethods.tw;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ArrayDequeueClass {

    private static Queue<String> queue = Stream.iterate("a", "a"::concat)
                                               .limit(10)
                                               .collect(Collectors.toCollection(ArrayDeque::new));


    static void queue(){
        System.out.println(queue);
        System.out.println(queue.size());  //10
        queue.clear();

        System.out.println(queue.add("b"));
        System.out.println(queue.add("b"));
        System.out.println(queue);
        System.out.println("allows duplicate \n");

//        System.out.println(queue.add(null));
//        System.out.println(queue.add(null));
        System.out.println(queue);
        System.out.println("doesn't allows null");

        System.out.println(queue.remove("a"));  //false
        System.out.println(queue.remove("b")); //true
        System.out.println(queue.add("a"));  //true
        System.out.println(queue.add("c"));  //true
        System.out.println(queue.add("d"));  //true
        System.out.println(queue);  //[b, a, c, d]

        System.out.println(queue.offer("e"));  //true
        System.out.println(queue.offer("f"));  //true
        System.out.println(queue);  //[b, a, c, d, e, f]

    }

    public static void main(String[] args) {
        queue();
    }
}
