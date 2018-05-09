package books.thinkigInJava._4ThEdition.chapters.concurrency.sharingResources.atomicityAndVolatility.volatility;

/**
 * If you declare a field to be
 * VOLATILE, THIS MEANS THAT AS SOON AS A WRITE OCCURS FOR THAT FIELD,
 * ALL READS WILL SEE THE CHANGE.
 * This is true even if local caches are involved—volatile fields
 * are immediately written through to main memory,
 * and reads occur from main memory.
 *
 * Synchronization also causes flushing to main memory,
 * so if a field is completely guarded by synchronized methods
 * or blocks, it is not necessary to make it volatile.
 *
 * volatile doesn’t work when the value of a field depends on
 * its previous value (such as incrementing a counter),
 * nor does it work on fields whose values are constrained by
 * the values of other fields,
 * such as the lower and upper bound of a Range class which
 * must obey the constraint lower <= upper.
 */
class Info {
}
