package oc.p.chapters.c_6_ExceptionsAndAssertions.usingTryWithResources.tw;

import java.io.EOFException;
import java.io.FileNotFoundException;

class ConstrCE implements AutoCloseable {

    ConstrCE() throws FileNotFoundException {
        throw new FileNotFoundException("constr FNFE");
    }

    @Override
    public void close() throws EOFException {
        throw new EOFException("close EOFE");
    }
}
