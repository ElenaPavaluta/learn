package oc.p.chapters._6_ExceptionsAndAssertions.usingTryWithResources.autoCloseable;

class Ac {

    void mTue() {
        try(TUE tue = new TUE()) {
            tue.m();
        }
    }

    void mTce() {
        try(TCE tce = new TCE()) {
            tce.m();
        } catch(Exception e) {
        }
    }

    class TUE implements AutoCloseable {

        void m() {
        }

        @Override
        public void close() throws RuntimeException {
            throw new RuntimeException();
        }
    }

    class TCE implements AutoCloseable {
        @Override
        public void close() throws Exception {
            throw new Exception();
        }

        void m() {
        }
    }
}
