package oc.p.chapters.c3_GenericsAndCollections.usingListsSetsMapsAndQueues.usingTheQueueInterface.workingWithQueueMethods.tw;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Null {

    public static void main(String[] args) {
        Null q = new Null();
//        q.queue();
//        q.deque();
        q.linkedList();
    }

    void queue() {
        Queue<String> queue = new ArrayDeque<>();
        queue.add("1");

        System.out.println(queue.peek());  //1
        System.out.println(queue.peek());  //1

        System.out.println();
        System.out.println(queue.poll());  //1
        System.out.println(queue.poll());  //null
        System.out.println(queue.peek());  //null
    }

    void deque(){
        Deque<String> deque = new ArrayDeque<>();
        deque.add("1");

        System.out.println(deque.peek());  //1
        System.out.println(deque.peek());  //1

        System.out.println();
        System.out.println(deque.poll());  //1
        System.out.println(deque.poll());  //null
        System.out.println(deque.poll());  //null
     }

     void linkedList(){
        Deque<String> q = new LinkedList<>();
         System.out.println(q.add("1"));  //true

         System.out.println(q.peek());  //1
         System.out.println(q.peek());  //1

         System.out.println();
         System.out.println(q.poll());  //1
         System.out.println(q.poll());  //null
         System.out.println(q.peek());  //null
     }
}
