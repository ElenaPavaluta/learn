package oc.p.chapters._6_ExceptionsAndAssertions.usingTryWithResources.tw._1;

class ACUncheckedException implements AutoCloseable {
    @Override
    public void close() throws IllegalStateException {
        throw new IllegalStateException("ISE");
    }
}
