package oc.p.chapters._7_Concurrency.usingConcurrentCollections.workingWithConcurrentClasses.queue;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

class Que {

    /**
     * -> Queue
     */
    ConcurrentLinkedQueue<Integer> concurrentLinkedQueue;

    /**
     * ->Deque -> Queue
     */
    ConcurrentLinkedDeque<Integer> concurrentLinkedDeque;

    /**
     * ->BlockingQueue -> Queue
     */
    LinkedBlockingQueue<Integer> linkedBlockingQueue;

    /**
     * BlockingDeque -> BlockingQueue & Deque
     */
    LinkedBlockingDeque<Integer> linkedBlockingDeque;
}
