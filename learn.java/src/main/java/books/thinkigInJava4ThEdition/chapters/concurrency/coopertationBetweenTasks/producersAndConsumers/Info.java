package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers;

/**
 * The only safe approach is to always
 * use the following idiom for a wait( )
 *
 * while(conditionlsNotMet) wait();
 *
 * It’s safer to call notifyAll( ),
 * which wakes up all the tasks waiting on that lock.
 * Each task must then decide whether
 * the notification is relevant.
 */
class Info {
}
