package oc.p.tests.chapters._13.q._11;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class Rmb {

    void m(){
        Queue<Integer> q = new ArrayDeque <>();

        q.add(1);  //throws exception if no available space

        q.offer(2);

        System.out.println(q);  //1, 2

        System.out.println(q.element());  //RE if no elem: 1

        System.out.println(q.peek());  //1

        System.out.println(q.remove());  //RE if no elem: 1

        System.out.println(q.poll());  //2
    }


    void m2(){
        Deque<Integer> dq = new ArrayDeque <>();

        dq.push(1);
        System.out.println(dq.pop());
    }

    public static void main(String[] args) {
        Rmb r  =new Rmb();
        r.m();
    }
}
