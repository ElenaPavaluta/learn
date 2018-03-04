package books.thinkigInJava4ThEdition.chapters.concurrency.terminatingTasks.checkingForAnInterrupt;

/**
 * Thread.interrupted()
 *
 * Note that when you call interrupt( ) on a thread,
 * the only time that the interrupt occurs is when the task enters,
 * or is already inside, a blocking operation
 * (except, as you’ve seen, in the case of
 * uninterruptible I/O or blocked synchronized methods,
 * in which case there’s nothing you can do).
 *
 */
class Info {
}
