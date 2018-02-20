package books.thinkigInJava4ThEdition.chapters.concurrency.sharingResources.atomicityAndVolatility.atomicity;

/**
 * Atomicity applies to "simple operations" on primitive types
 * except for longs and doubles.
 *
 *
 * READING AND WRITING PRIMITIVE VARIABLES OTHER THAN
 * LONG AND DOUBLE
 * IS GUARANTEED TO GO TO AND FROM MEMORY
 * AS INDIVISIBLE (ATOMIC) OPERATIONS.
 *
 *
 * However, the JVM is allowed to perform reads and writes
 * of 64- bit quantities (long and double variables)
 * as two separate 32-bit operations,
 * raising the possibility that a context switch could happen
 * in the middle of a read or write, and then different tasks
 * could see incorrect results
 * (this is sometimes called word tearing, because you might
 * see the value after only part of it has been changed).
 *
 *
 * ATOMIC OPERATIONS ARE THUS NOT INTERRUPTIBLE
 * BY THE THREADING MECHANISM
 *
 *
 * Changes made by one task, even if they’re atomic,
 * might not be visible to other tasks
 * (the changes might be temporarily stored in a local processor cache,
 * for example),
 * so different tasks will have a different view of
 * the application’s state
 *
 * The synchronization mechanism,
 * forces changes by one task on a multiprocessor system to be visible
 * across the application.
 * Without synchronization, it’s indeterminate when changes
 * become visible.
 *
 * Assignment and returning the value in a field will
 * usually be atomic.
 */
class Info {
}
