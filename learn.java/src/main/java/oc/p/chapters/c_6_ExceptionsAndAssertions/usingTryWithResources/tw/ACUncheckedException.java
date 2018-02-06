package oc.p.chapters.c_6_ExceptionsAndAssertions.usingTryWithResources.tw;

class ACUncheckedException implements AutoCloseable {
    @Override
    public void close() throws IllegalStateException {
        throw new IllegalStateException("ISE");
    }
}
