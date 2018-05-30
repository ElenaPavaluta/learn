package oc.p.chapters._6_ExceptionsAndAssertions.usingTryWithResources.tw;

class AcOk implements  AutoCloseable{
    @Override
    public void close() {
        System.out.println("AcOk");
    }
}
