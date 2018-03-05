package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.notifyVsNotifyAll;

/**
 * Using notify( ) instead of notifyAll( ) is an optimization.
 * Only one task of the possible many that are waiting on a lock
 * will be awoken with notify( ), so you must be certain that
 * the right task will wake up if you try to use notify( ).
 * In addition, all tasks must be waiting on the same condition
 * in order for you to use notify( ), because if you have tasks
 * that are waiting on different conditions,
 * you don’t know if the right one will wake up.
 * If you use notify( ), only one task must benefit when the
 * condition changes. Finally, these constraints must always be
 * true for all possible subclasses. If any of these rules cannot
 * be met, you must use notifyAll( ) rather than notify( )
 *
 *
 * notifyAll( ) DOES NOT WAKES UP ALL WAITING TASKS,
 * ONLY THOSE THAT ARE WAITING ON A PARTICULAR LOCK ARE WOKEN
 *
 */
class Info {
}
