package oc.p.chapters._6_ExceptionsAndAssertions.reviewingExceptions.exceptionsOnTheOcp.unchecked.java.lang;

class UnsupportedOperationException {

    interface I{
        void m();
    }

    class A implements I{
        @Override
        public void m() {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    void m(){
        new A().m();
    }

    static void m2(){
        new UnsupportedOperationException(). new A().m();
    }

    public static void main(String[] args) {
//       new UnsupportedOperationException(). m();
        m2();
    }
}
