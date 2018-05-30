package oc.p.chapters._6_ExceptionsAndAssertions.usingTryWithResources.tw;

class ACUncheckedException implements AutoCloseable {
    @Override
    public void close() throws IllegalStateException {
        throw new IllegalStateException("ISE");
    }
}
