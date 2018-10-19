package oc.p.chapters._6_ExceptionsAndAssertions.usingTryWithResources.tw._4;

import utils.print.Print;

import java.io.NotSerializableException;
import java.util.Arrays;

class Q {

    static int count = 0;

    class NSE implements AutoCloseable{
        @Override
        public void close() throws NotSerializableException {
            throw new NotSerializableException("NSE: " + ++count);
        }
    }

    void m() throws NotSerializableException {
        try (NSE nse = new NSE(); NSE nse2 = new NSE()){

        } catch (NotSerializableException e) {
            throw e;
        }finally {
            throw new NotSerializableException("Finally " + ++count);
        }
    }

    void m2(){
        try {
            m();
        }catch (NotSerializableException e){
            System.out.println(e.getMessage());
            Print.Delimitators.equal();
            Arrays.stream(e.getSuppressed()).forEach(q-> System.out.println(q.getMessage()));
        }
    }

    public static void main(String[] args) {
        new Q().m2();
    }

}
