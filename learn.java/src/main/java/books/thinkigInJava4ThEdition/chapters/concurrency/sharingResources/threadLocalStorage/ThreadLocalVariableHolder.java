package books.thinkigInJava4ThEdition.chapters.concurrency.sharingResources.threadLocalStorage;

import java.util.Random;

/**
 * protected T initialValue()
 *
 * Returns the current thread's "initial value" for
 * this thread-local variable.
 *
 * This method will be invoked the first time a thread
 * accesses the variable with the get() method,
 * unless the thread previously invoked the set(T) method,
 * in which case the initialValue method will not be
 * invoked for the thread. Normally,
 * this method is invoked at most once per thread,
 * but it may be invoked again in case of
 * subsequent invocations of remove() followed by get().
 *
 * This implementation simply returns null;
 * if the programmer desires thread-local variables
 * to have an initial value other than null,
 * ThreadLocal must be subclassed, and this method overridden.
 * Typically, an anonymous inner class will be used.
 */
class ThreadLocalVariableHolder {

    //anonymous inner class
    private static ThreadLocal<Integer> val = new ThreadLocal<Integer>(){
        private Random  rand = new Random(47);

        @Override
        protected synchronized Integer initialValue() {
            return rand.nextInt(1000);
        }
    };

    static void increment(){
        val.set(val.get() +1);
    }

    static int get(){
        return val.get();
    }
}
