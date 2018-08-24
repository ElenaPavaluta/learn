package oc.p.chapters._7_Concurrency.introducingThreads.distinguishingThreadTypes;

/**
 * A system thread is created by the JVM and runs in the background of
 * the application (GC)
 *
 * A user-defined thread is one created by the application developer to
 * accomplish a specific task
 *
 * A daemon thread is one that will not prevent the JVM from exiting
 * when the program finishes.
 *
 * A Java application terminates when the only threads that are running are
 * daemon threads.
 */
class ThreadTypes {
}
