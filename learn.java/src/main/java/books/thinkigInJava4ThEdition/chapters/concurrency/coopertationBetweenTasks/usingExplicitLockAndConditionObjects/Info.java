package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.usingExplicitLockAndConditionObjects;

/**
 * The basic class that uses a mutex and allows task suspension is the Condition,
 * and you can suspend a task by calling await( ) on a Condition.
 * When external state changes take place that might mean that a task
 * should continue processing, you notify the task by calling signal( ),
 * to wake up one task, or signalAll( ), to wake up all tasks that
 * have suspended themselves on that Condition object
 * (as with notifyAll( ), signalAll( ) is the safer approach).
 */
class Info {
}
