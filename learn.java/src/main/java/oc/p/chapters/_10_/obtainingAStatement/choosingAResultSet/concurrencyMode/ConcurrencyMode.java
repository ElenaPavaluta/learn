package oc.p.chapters._10_.obtainingAStatement.choosingAResultSet.concurrencyMode;

import oc.a.chapters._4_methods_and_encapsulation.simpleLambdas.necesity.Animal;

/**
 * By default, a ResultSet is in CONCUR_READ_ONLY mode.
 * This is what you need most of the time.
 * It means that you can’t update the result set. Most of the time, you will
 * use INSERT , UPDATE , or DELETE SQL statements to change the database rather than a
 * ResultSet .
 */
class ConcurrencyMode {

}
