package oc.p.chapters.c3_GenericsAndCollections.usingListsSetsMapsAndQueues.usingTheQueueInterface.workingWithQueueMethods;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * boolean add(E e): from Collection
 *
 * boolean offer(E e)
 */
class Add {

    static void queue(){
        Queue<String> q = new ArrayDeque<>();
        System.out.println(q.add("1")); //true
        System.out.println(q.add("2"));  //true
        System.out.println(q);

        System.out.println();
        q = new ArrayDeque<>(1);
        System.out.println(q.add("1"));  //true
        System.out.println(q.add("2"));  //true
        System.out.println(q);
    }

    static void deque(){
        Deque<String> dq = new ArrayDeque<>();
        System.out.println(dq.add("1"));  //true
        System.out.println(dq.add("2"));  //true
        System.out.println(dq);

        System.out.println();
        dq = new ArrayDeque<>(1);
        System.out.println(dq.add("1"));  //true
        System.out.println(dq.add("2"));  //true
        System.out.println(dq);
    }

    static void linkedList(){
        Deque<String> q = new LinkedList<>();
        System.out.println(q.add("1"));  //true
        System.out.println(q.add("2"));  //true
        System.out.println(q);

        System.out.println();
//        q = new LinkedList<String>(1);  //compiler error:  LinkedList doesn't have an initial size constructor
    }

    public static void main(String[] args) {
//        queue();
//        deque();
        linkedList();
    }
}
