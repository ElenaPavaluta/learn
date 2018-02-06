package oc.p.chapters.c_6_ExceptionsAndAssertions.usingTryWithResources.tw;

class AcOk implements  AutoCloseable{
    @Override
    public void close() {
        System.out.println("AcOk");
    }
}
