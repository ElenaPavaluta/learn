package oc.p.chapters._7_Concurrency.usingConcurrentCollections.workingWithConcurrentClasses.queue.tw;

import utils.print.Print;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.stream.IntStream;

class Que {

    Queue<Integer> queue = new ArrayDeque<>();

    {
        queue.add(1);
        queue.add(2);
        queue.add(3);
    }

    void print(){
        Print.print("queue", queue);
    }

    void offer(){
        queue.offer(4);
        print();
    }

    void element(){
        System.out.println(queue.element());  //1
        print();
        queue = new ArrayDeque<>();
        System.out.println(queue.element());  //RE
    }

    void poll(){
        System.out.println(queue.poll());  //1
        print();  //2 3
        IntStream.range(0, queue.size())
                .forEach(i->queue.poll());
        System.out.println(queue.poll());  //null
    }

    void remove(){
        System.out.println(queue.remove()); //1
        IntStream.range(0, queue.size())
                .forEach(i->queue.remove());
        queue.remove(); //RE
    }

    void peek(){
        System.out.println(queue.peek());  //1
        System.out.println(new ArrayDeque<Integer>().peek());
    }

    public static void main(String[] args) {
        Que q = new Que();

//        interview.offer();
//        interview.element();
//        interview.poll();
//        interview.remove();
        q.peek();
    }
}
