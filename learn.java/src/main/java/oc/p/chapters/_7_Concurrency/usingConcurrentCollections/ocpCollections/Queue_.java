package oc.p.chapters._7_Concurrency.usingConcurrentCollections.ocpCollections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;

class Queue_ {

    Queue <Ocp> queue;
    Deque <Ocp> deque;
    BlockingQueue <Ocp> blockingQueue;
    BlockingDeque <Ocp> blockingDeque;

    {
        queue = new LinkedList <>();
        queue = new ArrayDeque <>();

        queue = new ConcurrentLinkedQueue();
        queue = new ConcurrentLinkedDeque <>();

        queue = new LinkedBlockingQueue <>();
        queue = new LinkedBlockingDeque <>();
    }

    {
        deque = new LinkedList <>();
        deque = new ArrayDeque <>();

        deque = new ConcurrentLinkedDeque <>();

        deque = new LinkedBlockingDeque <>();
    }

    {
        blockingQueue = new LinkedBlockingQueue <>();
        blockingQueue = new LinkedBlockingDeque <>();
    }

    {
        blockingDeque = new LinkedBlockingDeque <>();
    }
}
