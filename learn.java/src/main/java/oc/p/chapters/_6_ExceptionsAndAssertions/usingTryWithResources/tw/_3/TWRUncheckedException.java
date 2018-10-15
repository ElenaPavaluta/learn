package oc.p.chapters._6_ExceptionsAndAssertions.usingTryWithResources.tw._3;

import java.io.NotSerializableException;
import java.util.Arrays;

class TWRUncheckedException {
    class NPE implements AutoCloseable{
        @Override
        public void close() throws NullPointerException {
            throw new NullPointerException("NPE");
        }
    }

    class IAE implements AutoCloseable{
        @Override
        public void close() throws IllegalArgumentException {
            throw new IllegalArgumentException("IAE");
        }
    }

    class CCE implements AutoCloseable{
        @Override
        public void close() throws ClassCastException {
            throw new ClassCastException("CCE");
        }
    }

    void m(){
        try(NPE npe = new NPE();
        IAE iae = new IAE();
        CCE cce = new CCE()){
            throw new NotSerializableException("NSE");
        }catch (NotSerializableException e){
            System.out.println(e.getMessage());
            Arrays.stream(e.getSuppressed()).forEach(q->System.out.println(q.getMessage()));
        }
    }

    public static void main(String[] args) {
        TWRUncheckedException t = new TWRUncheckedException();
        t.m();
    }
}
