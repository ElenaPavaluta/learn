package oc.p.chapters._6_ExceptionsAndAssertions.usingTryWithResources.tw.imp;

import java.io.BufferedReader;
import java.io.IOException;

class Rmb {

    static void m(){
        try{
            System.out.println("this is legal");
        }catch (Exception e){

        }
    }

    static void m2(){
        try (BufferedReader bf = null){
            System.out.println("This is also legal because the compiler doesn't know what de " +
                    "try with resource block might throw");
        }catch (IOException e){

        }
    }

    static void m3(){
        try(BufferedReader br = null){
//            br = null;
            System.out.println("br = null not legal," +
                    " the declared variables are final");
        }catch (RuntimeException | IOException e){

        }
    }

    public static void main(String[] args) {
//        m();
//        m2();
        m3();
    }
}
