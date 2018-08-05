package oc.p.chapters._3_GenericsAndCollections.usingListsSetsMapsAndQueues.usingTheQueueInterface
        .workingWithQueueMethods.tw._2.queue;


import utils.print.Print;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class LL {

    Queue<Integer> q;

    void print() {
        Print.print("queue as LinkedList: ", q);
    }

    /**
     * RE if no space available
     */
    void add() {
        q = new LinkedList<>();
        System.out.println(q.add(1));
        System.out.println(q.add(2));
        print();
    }

    void offer(){
        q = new LinkedList<>();
        System.out.println(q.offer(1));
        System.out.println(q.offer(2));
        print();
    }

    /**
     * RE if no elem available
     */
    void remove(){
        init();
        System.out.println(q.remove());  //1
        System.out.println(q.remove());  //RE
    }

    void poll(){
        init();
        System.out.println(q.poll());  //1
        System.out.println(q.poll());  //null
    }


    private void init() {
        q = new LinkedList<>();
        q.add(1);
    }

    /**
     * RE if no elem available
     */
    void element(){
        init();
        System.out.println(q.element());  //1
        q.poll();  //actual remove
        System.out.println(q.element());  //RE
    }

    void peek(){
        init();
        System.out.println(q.peek());  //1
        q.poll();  //actual remove
        System.out.println(q.peek());  //null
    }

    public static void main(String[] args) {
        LL ll = new LL();

//        ll.add();
//        ll.offer();

//        ll.remove();
//        ll.poll();

//        ll.element();
        ll.peek();
    }
}
