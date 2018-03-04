package books.thinkigInJava4ThEdition.chapters.concurrency.terminatingTasks.interruption.info;

/**
 * In order to terminate a blocked task one must call the
 * interrupt() method.
 *
 * This sets the interrupted status for that thread.
 * A thread with its interrupted status set will throw an
 * InterruptedException if it is already blocked or if it
 * attempts a blocking operation.
 * The interrupted status will be reset when the exception
 * is thrown or if the task calls Thread.interrupted( ).
 *
 */
class Info {
}
