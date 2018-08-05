package oc.p.chapters._3_GenericsAndCollections.usingListsSetsMapsAndQueues.usingTheQueueInterface
        .workingWithQueueMethods.tw._2.deque;


import utils.print.Print;
import java.util.ArrayDeque;
import java.util.Deque;

class Ad {

    Deque<Integer> dq;

    public static void main(String[] args) {
        Ad ad = new Ad();

//        ad.add();
//        ad.offer();

//        ad.remove();
//        ad.poll();

//        ad.element();
//        ad.peek();

//        ad.push();
        ad.pop();
    }

    void print() {
        Print.print("deque: ", dq);
    }

    /**
     * RE if no space available
     */
    void add() {
        dq = new ArrayDeque<>(1);
        System.out.println(dq.add(1));
        System.out.println(dq.add(2));
        print();
    }

    void offer() {
        dq = new ArrayDeque<>(1);
        System.out.println(dq.offer(1));
        System.out.println(dq.offer(2));
        print();
    }

    /**
     * RE if no elem available
     */
    void remove() {
        init();
        System.out.println(dq.remove());  //1
        System.out.println(dq.remove());  //RE
    }

    void poll() {
        init();
        System.out.println(dq.poll());  //1
        System.out.println(dq.poll());  //null
    }

    /**
     * RE if no elem available
     */
    void element(){
        init();
        System.out.println(dq.element());  //1
        dq.poll();
        System.out.println(dq.element());  //RE
    }

    void peek(){
        init();
        System.out.println(dq.peek());  //1
        dq.poll();
        System.out.println(dq.peek());  //null
    }


    /**
     * RE if no space available
     */
    void push(){
        init();
        dq.push(77);
        print();
    }

    /**
     * RE if no elem available
     */
    void pop(){
        init();
        System.out.println(dq.pop());  //1
        System.out.println(dq.size());  //0

        System.out.println(dq.pop());  //RE
    }

    private void init() {
        dq = new ArrayDeque<>();
        dq.offer(1);
    }
}
