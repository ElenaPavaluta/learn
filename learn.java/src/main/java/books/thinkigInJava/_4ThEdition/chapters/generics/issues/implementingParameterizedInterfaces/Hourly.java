
package books.thinkigInJava._4ThEdition.chapters.generics.issues.implementingParameterizedInterfaces;
/**
 * Compiler error:
 *
 * Because erasure reduces Payable<Employee> and Payable<Hourly> to the same
 * class, Payable, would mean that one you'd be implementing the same interface
 * twice.
 *
 * If you remove the generic parameters from both uses of
 * Payable—as the compiler does during erasure—the code compiles.
 */

//class Hourly extends Employee implements Payable<Hourly> {
//}


//class Hourly extends Employee implements Payable{
//}
