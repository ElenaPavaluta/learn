package oc.p.chapters._3_GenericsAndCollections.usingListsSetsMapsAndQueues.usingTheQueueInterface
        .workingWithQueueMethods.tw._2.queue;


import utils.print.Print;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class AD {
    Queue<Integer> queue;

    public static void main(String[] args) {
        AD ad = new AD();

//        ad.add();
//        ad.offer();

//        ad.remove();
//        ad.poll();

//        ad.element();
        ad.peek();
    }

    void print() {
        Print.print("queue: ", queue);
    }

    void add() {
        queue = new ArrayDeque<>(1);
        System.out.println(queue.add(1));
        print();

        System.out.println(queue.add(2));  //throws exception if no space available
        print();
    }

    void offer() {
        queue = new ArrayDeque<>(1);
        System.out.println(queue.offer(1));
        print();

        System.out.println(queue.offer(2));
        print();
    }

    /**
     * Throws RE if no element available
     */
    void remove() {
        init();
        System.out.println(queue.remove());

        System.out.println(queue.remove());
    }

    void poll() {
        init();
        System.out.println(queue.poll());

        System.out.println(queue.poll());
    }

    private void init() {
        queue = new ArrayDeque<>();
        queue.offer(1);
    }

    /**
     * Throws RE if no element available
     */
    void element() {
        init();
        System.out.println(queue.element());
        queue.poll();
        System.out.println(queue.element());
    }

    void peek() {
        init();
        System.out.println(queue.peek());
        queue.poll();
        System.out.println(queue.peek());

    }
}
