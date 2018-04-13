package oc.p.chapters.c3_GenericsAndCollections.usingListsSetsMapsAndQueues.usingTheQueueInterface.workingWithQueueMethods;

import java.util.ArrayDeque;
import java.util.Queue;

class Offer {

    static void q(){
        Queue<String> q = new ArrayDeque<>();
        System.out.println(q.offer("1"));  //true
        System.out.println(q.offer("2"));  //true
        System.out.println(q);

        System.out.println();
        q = new ArrayDeque<>(1);
        System.out.println(q.offer("1"));  //true
        System.out.println(q.offer("2"));  //true
        System.out.println(q);
    }

    public static void main(String[] args) {
        q();
    }
}
