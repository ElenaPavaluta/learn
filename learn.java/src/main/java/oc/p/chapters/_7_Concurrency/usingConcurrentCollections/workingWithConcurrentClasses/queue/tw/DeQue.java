package oc.p.chapters._7_Concurrency.usingConcurrentCollections.workingWithConcurrentClasses.queue.tw;

import utils.print.Print;

import java.util.ArrayDeque;
import java.util.Deque;

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

    void

    public static void main(String[] args) {
        DeQue dq = new DeQue();

        dq.print();
    }
}
