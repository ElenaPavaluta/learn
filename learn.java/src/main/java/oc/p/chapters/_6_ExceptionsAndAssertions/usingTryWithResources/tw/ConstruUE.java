package oc.p.chapters._6_ExceptionsAndAssertions.usingTryWithResources.tw;

class ConstruUE implements AutoCloseable{

    ConstruUE(){
        throw new IllegalStateException("constr ISE");
    }


    @Override
    public void close() throws IllegalStateException {
        throw new IllegalStateException("close ISE");
    }
}
