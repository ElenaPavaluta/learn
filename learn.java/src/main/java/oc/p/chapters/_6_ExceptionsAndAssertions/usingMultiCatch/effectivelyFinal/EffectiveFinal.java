package oc.p.chapters._6_ExceptionsAndAssertions.usingMultiCatch.effectivelyFinal;

import com.sun.org.apache.xerces.internal.impl.dv.xs.SchemaDateTimeException;
import java.io.FileNotFoundException;
import java.time.DateTimeException;

/**
 * Beware!
 * e = new Exception():  not allowed (compiler error) for the multi-catch block
 */
class EffectiveFinal {

    void dte() throws DateTimeException {
    }

    void fnfe() throws FileNotFoundException {
    }

    void m00() {
        try {
            dte();
            fnfe();
        } catch(Exception e) {
            e = new SchemaDateTimeException();  //some random exception;
            // the point is that this is possible,
            // but it isn't possible with the multi-catch block
        }
    }

    void m0() {
        try {
            fnfe();
        } catch(FileNotFoundException e) {
            e = new FileNotFoundException(e.getMessage());  //an assigment is possible
        }
    }

    void m() {
        try {
            fnfe();
            dte();
        } catch(DateTimeException e) {
//            throw new RuntimeException(e);  //ok
            e = new DateTimeException(e.getMessage());  //an assignment is pssible
        } catch(FileNotFoundException e) {
//            throw new RuntimeException(e);  //ok
            e = new FileNotFoundException(e.getMessage());  //an assignment is possible
        }
    }

    void m2() {
        try {
            dte();
            fnfe();
        } catch(DateTimeException | FileNotFoundException e) {

//            e = new DateTimeException(e.getMessage());  //e is effectively final
//            e = new FileNotFoundException(e.getMessage());  //e is effectively final

            throw new RuntimeException(e);
        }
    }
}
