package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.producerConsumersAndQueues;

/**
 * java.util.concurrent.BlockingQueue interface,
 * has a number of standard implementations. You’ll usually use the
 * LinkedBlockingQueue, which is an unbounded queue;
 * the ArrayBlockingQueue has a fixed size, so you can only put so
 * many elements in it before it blocks.
 *
 * These queues also suspend a consumer task if that task tries to get
 * an object from the queue and the queue is empty, and resume when more
 * elements become available. Blocking queues can solve a remarkable number
 * of problems in a much simpler and more reliable fashion than
 * wait( ) and notifyAll( ).
 */
class Info {
}
