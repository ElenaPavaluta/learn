package oc.p.chapters.c3_GenericsAndCollections.usingListsSetsMapsAndQueues.usingTheQueueInterface.comparingQueueImplementations;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * Not allow null elements because it methods either return special value [null/false] or throw an exception
 *
 */
class Compare {

    private Queue<String> linkedList = new LinkedList<>();
    private Queue<String> deQueue = new ArrayDeque<>();
}
