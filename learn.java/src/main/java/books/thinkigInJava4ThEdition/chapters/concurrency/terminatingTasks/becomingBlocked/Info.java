package books.thinkigInJava4ThEdition.chapters.concurrency.terminatingTasks.becomingBlocked;

/**
 *
 * A task can become blocked for the following reasons:
 *
 * You’ve put the task to sleep by calling sleep(milliseconds),
 * in which case it will not be run for the specified time.
 *
 * You’ve suspended the execution of the thread with wait( ).
 * It will not become runnable again until the thread gets the
 * notify( ) or notifyAll( ) message
 * (or the equivalent signal( ) or signalAll( ) for the
 * Java SE5 java.util.concurrent library
 *
 * The task is waiting for some I/O to complete.
 *
 * The task is trying to call a synchronized method on another object,
 * and that object’s lock is not available because it has already
 * been acquired by another task.
 *
 *
 *
 * calling join()
 */
class Info {
}
