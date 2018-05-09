package books.thinkigInJava._4ThEdition.chapters.concurrency.newLibraryComponents.exchanger;

/**
 * An Exchanger is a barrier that swaps objects between two tasks.
 * When the tasks enter the barrier, they have one object,
 * and when they leave, they have the object that was formerly held by
 * the other task. Exchangers are typically used when one task is
 * creating objects that are expensive to produce and another task
 * is consuming those objects; this way, more objects can be created
 * at the same time as they are being consumed.
 */
class Info {
}
