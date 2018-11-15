package oc.p.chapters._3_GenericsAndCollections.usingListsSetsMapsAndQueues.usingTheQueueInterface.workingWithQueueMethods;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * E poll(): return null if no element available
 *
 * E remove(): throws RE if no element available
 *
 * E pop(): throws RE if no element available
 */
class Poll {

    static void q(){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);

        System.out.println(q.remove()); //1
        System.out.println(q.poll()); //2
//        System.out.println(interview.pop());  //Deque method

        System.out.println(q.poll());  //null
        System.out.println(q.remove());  //RE
    }

    static void dq(){
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(1);
        dq.add(2);
        dq.add(3);

        System.out.println(dq.poll());  //1
        System.out.println(dq.pop());  //2
        System.out.println(dq.remove());  //3

        System.out.println(dq.poll());  //null
//        System.out.println(dq.pop());  //RE
        System.out.println(dq.remove());  //RE
    }

    static void ll(){
        LinkedList ll = new LinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);

        System.out.println(ll.poll());  //1
        System.out.println(ll.pop());  //2
        System.out.println(ll.remove());  //3

        System.out.println(ll.poll());  //null
//        ll.pop();  //RE
        ll.remove();  //RE
    }

    public static void main(String[] args) {
//        interview();
//        dq();
        ll();
    }
}
