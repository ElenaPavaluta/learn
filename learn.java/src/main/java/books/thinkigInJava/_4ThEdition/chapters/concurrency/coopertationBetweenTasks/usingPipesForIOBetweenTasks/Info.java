package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.usingPipesForIOBetweenTasks;

/**
 * It’s often useful for tasks to communicate with each other using I/O.
 * Threading libraries may provide support for inter-task I/O in the form
 * of pipes. These exist in the Java I/O library as the classes
 * PipedWriter (which allows a task to write into a pipe) and
 * PipedReader (which allows a different task to read from the same pipe).
 * This can be thought of as a variation of the producer-consumer problem,
 * where the pipe is the canned solution.
 * The pipe is basically a blocking queue, which existed in versions of
 * Java before BlockingQueue was introduced.
 *
 *
 * An important difference between a PipedReader and normal I/O is
 * seen when shutdownNow( ) is called—the PipedReader is interruptible,
 * whereas if you changed, for example, the in.read( ) call to
 * System.in.read( ), the interrupt( ) would fail to break out
 * of the read( )call.
 */
class Info {
}
