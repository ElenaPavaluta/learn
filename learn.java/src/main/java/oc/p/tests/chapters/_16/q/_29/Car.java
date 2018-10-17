package oc.p.tests.chapters._16.q._29;

import java.io.IOException;

class CarCrash extends RuntimeException{
}

class Car {

    static void m() throws Exception{
        try{
            throw new IOException("Auto-pilot error");
        }catch (Exception /*| CarCrash*/ e){
            throw e;
        }/*catch (Exception a){
            throw a;
        }*/
    }
}
