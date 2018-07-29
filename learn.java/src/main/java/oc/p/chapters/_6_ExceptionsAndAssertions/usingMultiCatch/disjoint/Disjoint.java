package oc.p.chapters._6_ExceptionsAndAssertions.usingMultiCatch.disjoint;

import java.io.EOFException;
import java.io.IOException;
import java.time.format.DateTimeParseException;

/**
 * Java intends multi-catch to be used for exceptions that aren’t related,
 * and it prevents you from specifying redundant types in a multi-catch.
 */
class Disjoint {

    public static void main(String[] args) {
        Disjoint d = new Disjoint();
        d.m();
    }

    void eofe() throws EOFException {
    }

    void dtpe() throws DateTimeParseException {
    }

    void re() throws RuntimeException {
    }

    void ioe() throws IOException {
    }

    void m() {
        try {
            eofe();
            dtpe();
            re();
            ioe();
        } catch(EOFException e) {

        } catch(DateTimeParseException e) {

        } catch(IOException e) {

        } catch(RuntimeException e) {

        }
    }

    /**
     * Beware! compilerError for
     *
     * catch(EOFException | DateTimeParseException | RuntimeException | IOException e)
     *
     * only what has been used is legal - shorter and more concise: and it uses the most classes involved
     */
    void m2() {
        try {
            eofe();
            dtpe();
            re();
            ioe();
        } catch(RuntimeException | IOException e) {
            /**
             * Cannot assign a value to final variable e
             */
//            e = new RuntimeException(e);
            throw new RuntimeException(e);
        }
    }
}
