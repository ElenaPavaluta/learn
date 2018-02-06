package oc.p.chapters.c_6_ExceptionsAndAssertions.workingWithAssertions.enablingAssertions;

/**
 * https://docs.oracle.com/cd/E19683-01/806-7930/assert-4/index.html
 *
 * java -enableassertions className
 *
 * java -ea className
 *
 * Using the
 * -enableassertions
 * -ea
 * without any arguments enables assertions in all classes except system classes (Java runtime classes)
 *
 *
 * java -ea:com.wiley.demos... my.programs.Main : enables assertions only for classes in the com.wiley.demos package and any subpackages
 * the three dots means any class in the specified package or subpackages
 *
 * java -ea:com.wiley.demos.TestColors my.programs.Main : enable assertions for a specific class
 *
 * java -ea:com.wiley.demos... -da:com.wiley.demos.TestColors my.programs.Main : enables assertions for the com.wiley.demos package but disables assertions for the TestColors class
 *
 * Disableing assertiion:
 * java  -disableassertions
 * -da
 */
class EA {

    static void m() {
        assert false : "this is false";
    }

    public static void main(String[] args) {
        m();
    }
}
