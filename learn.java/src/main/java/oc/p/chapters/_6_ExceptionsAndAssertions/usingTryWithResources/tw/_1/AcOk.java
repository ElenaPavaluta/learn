package oc.p.chapters._6_ExceptionsAndAssertions.usingTryWithResources.tw._1;

class AcOk implements  AutoCloseable{
    @Override
    public void close() {
        System.out.println("AcOk");
    }
}
