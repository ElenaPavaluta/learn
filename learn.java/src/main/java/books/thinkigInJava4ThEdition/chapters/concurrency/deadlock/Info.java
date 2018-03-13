package books.thinkigInJava4ThEdition.chapters.concurrency.deadlock;

/**
 * Deadlock can occur if four conditions are simultaneously met:
 *
 * 1. Mutual exclusion. At least one resource used by the tasks must not be shareable.
 * In this case, a Chopstick can be used by only one Philosopher at a time.
 *
 * 2. At least one task must be holding a resource and waiting to acquire a resource currently
 * held by another task. That is, for deadlock to occur, a Philosopher must be holding one
 * Chopstick and waiting for another one.
 *
 * 3. A resource cannot be preemptively taken away from a task.
 * Tasks only release resources as a normal event. Our Philosophers are polite and they don’t grab
 * Chopsticks from other Philosophers.
 *
 * 4. A circular wait can happen, whereby a task waits on a resource held by another task,
 * which in turn is waiting on a resource held by another task, and so on, until one
 * of the tasks is waiting on a resource held by the first task, thus gridlocking everything.
 * In DeadlockingDiningPhilosophers.java, the circular wait happens because each Philosopher
 * tries to get the right Chopstick first and then the left.
 */
class Info {
}
