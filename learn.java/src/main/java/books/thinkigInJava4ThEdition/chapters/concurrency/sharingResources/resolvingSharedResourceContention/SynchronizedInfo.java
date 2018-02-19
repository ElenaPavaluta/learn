package books.thinkigInJava4ThEdition.chapters.concurrency.sharingResources.resolvingSharedResourceContention;

/**
 * All objects automatically contain a single lock
 * (also referred to as a monitor). When you call any
 * synchronized method, that object is locked and no other
 * synchronized method of that object can be called until
 * the first one finishes and releases the lock.
 *
 *
 * It’s especially important to make fields private when working
 * with concurrency; otherwise the synchronized keyword
 * cannot prevent another task from accessing a field directly,
 * and thus producing collisions.
 */
class SynchronizedInfo {

    /**
     * There’s also a single lock per class
     * (as part of the Class object for the class),
     * so that synchronized static methods can lock each
     * other out from simultaneous access of static data
     * on a class-wide basis.
     */
    static synchronized void synchronizedStaticMethod() {

    }

    /**
     * if f( ) is called for an object by one task,
     * a different task cannot call f( ) or g( )
     * for the same object until f( )
     * is completed and releases the lock
     */

    synchronized void f() {
    }

    synchronized void g() {
    }

    /**
     * One task may acquire an object’s lock multiple times.
     * This happens if one method calls a second method on the
     * same object, which in turn calls another method on
     * the same object, etc.
     *
     * The JVM keeps track of the number of times the object
     * has been locked.
     *
     * If the object is unlocked, it has a count of zero.
     * As a task acquires the lock for the first time,
     * the count goes to one.
     * Each time the same task acquires another lock
     * on the same object, the count is incremented.
     * Naturally, multiple lock acquisition
     * is only allowed for the task that acquired
     * the lock in the first place.
     * Each time the task leaves a synchronized method,
     * the count is decremented, until the count goes
     * to zero, releasing the lock entirely for use by
     * other tasks
     */
    synchronized void a() {
        a();
    }

    synchronized void b() {
        b();
    }

    synchronized void c() {
    }
}


