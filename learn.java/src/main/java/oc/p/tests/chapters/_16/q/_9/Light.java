package oc.p.tests.chapters._16.q._9;

import java.io.IOException;

class Light {

    void turnOn() throws IOException{
//        new IOException("Not ready");
        throw new IOException("IOE");
    }

    void m() throws Exception{
        try {
            turnOn();
        }catch (RuntimeException e){
            System.out.println(e);
            throw new IOException();
        }finally {
            System.out.println("complete");
        }
    }

    public static void main(String[] args) throws Exception {
        Light l = new Light();
        l.m();
    }
}
