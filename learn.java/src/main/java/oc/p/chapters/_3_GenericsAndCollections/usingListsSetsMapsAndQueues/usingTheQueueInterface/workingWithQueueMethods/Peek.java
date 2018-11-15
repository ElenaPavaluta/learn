package oc.p.chapters._3_GenericsAndCollections.usingListsSetsMapsAndQueues.usingTheQueueInterface.workingWithQueueMethods;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * E peek() - returns null if no available element
 * E element() - throws RE if no available element
 */
class Peek {

    static void q(){
        Queue<String> q = new ArrayDeque<>();

        System.out.println(q.peek());  //null
        System.out.println(q.element());  //RE
    }

    static void dq(){
        Deque<String> dq = new ArrayDeque<>();

        System.out.println(dq.peek());  //null
        System.out.println(dq.element()); //RE
    }

    static void ll(){
        LinkedList<String> ll = new LinkedList<>();

        System.out.println(ll.peek());  //null
        System.out.println(ll.element());  //RE
    }

    public static void main(String[] args) {
//        interview();
//        dq();
        ll();
    }
}

