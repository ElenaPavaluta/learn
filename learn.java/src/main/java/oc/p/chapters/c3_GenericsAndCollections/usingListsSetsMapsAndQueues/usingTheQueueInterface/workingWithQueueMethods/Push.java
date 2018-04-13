package oc.p.chapters.c3_GenericsAndCollections.usingListsSetsMapsAndQueues.usingTheQueueInterface.workingWithQueueMethods;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * void push(E e)
 */
class Push {

    static void dq() {
        Deque<String> dq = new ArrayDeque<>();

        dq.push("1");
        dq.push(null);  //RE:  queue does not accept null
    }

    static void ll() {
        LinkedList<String> ll = new LinkedList<>();

        ll.push("2");
        ll.push(null);
        System.out.println(ll);
    }

    public static void main(String[] args) {
//        dq();
        ll();
    }
}
