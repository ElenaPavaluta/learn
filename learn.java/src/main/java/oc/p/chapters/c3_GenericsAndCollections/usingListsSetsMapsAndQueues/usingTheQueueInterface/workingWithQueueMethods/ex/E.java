package oc.p.chapters.c3_GenericsAndCollections.usingListsSetsMapsAndQueues.usingTheQueueInterface.workingWithQueueMethods.ex;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class E {

    static void q(){
        Queue<Integer> queue = new ArrayDeque<>();
        System.out.println(queue.offer(10));  //true
        System.out.println(queue.offer(4));  //true
        System.out.println(queue.peek());  //10
        System.out.println(queue.poll());  //10
        System.out.println(queue.poll());  //4
        System.out.println(queue.peek());  //null
    }

    static void stack(){
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(10);
        stack.push(4);
        System.out.println(stack.peek());  //4
        System.out.println(stack.poll());  //4
        System.out.println(stack.poll());  //10
        System.out.println(stack.peek());
    }

    public static void main(String[] args) {
//        queue();
        stack();
    }
}
