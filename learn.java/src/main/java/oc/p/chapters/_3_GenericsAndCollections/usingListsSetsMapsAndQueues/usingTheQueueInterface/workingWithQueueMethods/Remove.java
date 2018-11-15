package oc.p.chapters._3_GenericsAndCollections.usingListsSetsMapsAndQueues.usingTheQueueInterface.workingWithQueueMethods;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * boolean remove(Object o); from Collection; Object as parameter due to the fact that it needs to call equals(Object)
 *
 * E remove(): throws RE if no element available
 *
 * E pool(): return null if no element available
 */
class Remove {

    static void q(){
        Queue<String> q = new ArrayDeque<>();
        q.add("1");
        q.add("2");

        q.remove("2");

        System.out.println(q.remove());  //1

        System.out.println(q.poll());  //null
        System.out.println(q.remove());  //RE
    }

    static void ll(){
        LinkedList<String> ll = new LinkedList<>();
        ll.add("1");

        System.out.println(ll.remove());  //1

        System.out.println(ll.poll());  //null
        System.out.println(ll.remove());  //RE
    }

    public static void main(String[] args) {
//        interview();
        ll();
    }

}
