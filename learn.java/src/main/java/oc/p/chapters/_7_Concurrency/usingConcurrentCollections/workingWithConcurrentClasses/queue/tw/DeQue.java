package oc.p.chapters._7_Concurrency.usingConcurrentCollections.workingWithConcurrentClasses.queue.tw;

import utils.print.Print;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

class DeQue {

    Deque<Integer> dq = new ArrayDeque<>();
    {
        dq.offer(1);
        dq.offer(2);
        dq.offer(3);
    }

    void print(){
        Print.print("dq", dq);
    }

    void push(){
        dq.push(4);  // 4 1 2 3
        print();

        dq.push(5);  // 5 4 1 2 3
        print();
    }

    void pop(){
        System.out.println(dq.pop());  //1
        print();

        IntStream.range(0, dq.size()).forEach(i-> System.out.println(dq.pop()));

        dq.pop();  //RE
    }

    void peek(){
        System.out.println(dq.peek());  //1
        print();
    }

    public static void main(String[] args) {
        DeQue dq = new DeQue();

//        dq.print();
//        dq.push();
//        dq.pop();
        dq.peek();
    }
}
