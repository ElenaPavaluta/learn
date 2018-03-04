package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.waitAndNotifyAll;

/**
 *
 * sleep( ) and yield() does not release the object lock they're called
 * but
 * wait( ) releases the lock.
 *
 * void	wait() throws InterruptedException
 * Causes the current thread to wait until another
 * thread invokes the notify() method or the notifyAll() method
 * for this object.
 *
 * void wait(long timeout) throws InterruptedException / wait(long timeout, int nanos) throws InterruptedException
 * Causes the current thread to wait until either another
 * thread invokes the notify() method or the notifyAll() method
 * for this object, or a specified amount of time has elapsed.
 *
 * One fairly unique aspect of wait( ), notify( ), and notifyAll( )
 * is that these methods are part of the base class object
 * and not part of thread. Although this seems a bit strange
 * at first—to have something that’s exclusively for threading
 * as part of the universal base class—it’s essential because
 * these methods manipulate the lock that’s also part of every object.
 * As a result, you can put a wait( ) inside any synchronized method,
 * regardless of whether that class extends Thread or implements
 * Runnable. In fact, the only place you can call wait( ), notify( ),
 * or notifyAll( ) is within a synchronized method or block
 * (sleep( ) can be called within non-synchronized methods since it
 * doesn’t manipulate the lock). If you call any of these within
 * a method that’s not synchronized, the program will compile,
 * but when you run it, you’ll get an IllegalMonitorStateException
 *
 * You can ask another object to perform an operation that
 * manipulates its own lock. To do this, you must first capture that object’s lock. For example, if you want to send notifyAll( ) to an object x, you must do so inside a synchronized block that acquires the lock for x:
 * synchronized(x) {x.notifyAll();}
 */
class Info {
}
