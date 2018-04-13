package oc.p.chapters.c3_GenericsAndCollections.usingListsSetsMapsAndQueues.usingTheQueueInterface.workingWithQueueMethods;

import javax.sound.midi.SoundbankResource;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * E element() - throws RE if no available element
 * E peek() - returns null if no available element
 */
class Element {

    static void q(){
        Queue<String> q = new ArrayDeque<>();
        System.out.println(q.add("1"));  //true

        System.out.println(q.remove("2"));  //false; from Collection

        System.out.println(q.element());  //1
        System.out.println(q.remove());  //"1

        System.out.println(q.peek());  //null

        System.out.println(q.element());  //RE: NoSuchElementException
    }

    static void dq(){
        Deque<String> dq = new ArrayDeque<>();
        System.out.println(dq.offer("1"));  //true

        System.out.println(dq.element());  //1
        System.out.println(dq.remove("1"));  //true

        System.out.println(dq.peek());  //null

        System.out.println(dq.element());  //RE: NoSuchElementException
    }

    static void ll(){
        LinkedList<String> ll = new LinkedList<>();
        System.out.println(ll.offer("1"));  //true

        System.out.println(ll.element()); //1
        System.out.println(ll.remove());  //1

        System.out.println(ll.peek());  //null
        ll.element();  //RE: NoSuchElementException
    }

    public static void main(String[] args) {
//        q();
//        dq();
        ll();
    }
}
