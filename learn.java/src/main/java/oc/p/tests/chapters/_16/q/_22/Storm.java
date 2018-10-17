package oc.p.tests.chapters._16.q._22;

import java.io.IOException;

class Storm {

    static void m() throws Exception{
        try(final AutoCloseable ac = new AutoCloseable() {
            @Override
            public void close() throws RuntimeException {
            }
        }){
            System.out.println(ac.toString());

            /**
             * Because is declaring that it
             * might throw an exception, this is valid
             */
        }catch (IOException e){
            /**
             * ac is out of scope once the catch block starts
             */
//            if(ac !=null){}
        }finally {
            System.out.println("Storm gone");
        }
    }

    public static void main(String[] args) throws Exception {
        m();
    }
}
