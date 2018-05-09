package books.thinkigInJava._4ThEdition.chapters.concurrency.sharingResources.atomicityAndVolatility.volatility;

/**
 * Defining a variable as volatile,
 * tells the compiler not to do any optimizations
 * that would remove reads and writes that keep the
 * field in exact synchronization with the local data in the threads.
 *
 * In effect, reads and writes go directly to memory,
 * and are not cached,
 *
 * volatile also restricts compiler reordering
 * of accesses during optimization
 *
 * MAKE A FIELD VOLATILE IF THAT FIELD COULD BE SIMULTANEOUSLY
 * ACCESSED BY MULTIPLE TASKS, AND AT LEAST ONE OF THOSE ACCESSES
 * IS A WRITE
 */
class SerialNbGenerator {

    /**
     * serialNb field is volatile because
     * it is possible for each thread to have
     * a local stack and maintain copies of some variables there
     */
    private static volatile int serialNb = 0;

    static /*synchronized*/ int nxtSerialNb(){
        /**
         * the increment operation isn't Thread safe
         * because involves both a read and a write
         */
        return serialNb++;  //Not Thread Safe
    }
}
