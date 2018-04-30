package books.thinkigInJava4ThEdition.chapters.generics.compensatingForErasure.arraysOfGenerics.tw.genericArray;

import sun.util.resources.cldr.br.CurrencyNames_br;

class C3 {
    interface I {
    }

    interface I2 {
    }

    class A implements I {

    }

    final class B extends A {

    }

    static A[] aArr;
    static B[] bArr;

    static void m(){
        System.out.println(aArr instanceof A[]);  //false
        System.out.println(bArr instanceof B[]);  //false
    }

    static void m2(){
        aArr  =new A[5];

        System.out.println(aArr instanceof A[]);  //true
        System.out.println(aArr instanceof I[]);  //true
        System.out.println(aArr instanceof B[]);  //false
        System.out.println(aArr instanceof I2[]);  //false
        System.out.println(aArr instanceof Object[]);  //true
    }

    static void m3(){
        bArr = new B[5];

        System.out.println(bArr instanceof Object[]);  //true
        System.out.println(bArr instanceof I[]);  //true
        System.out.println(bArr instanceof A[]);  //true
        System.out.println(bArr instanceof B[]);  //true


        /**
         * Compiler error
         * B is final, so no subsclass of B could also implement I2
         */
//        System.out.println(bArr instanceof I2);
    }

    static void m4(){
        aArr = new B[5];  //ok

        System.out.println(aArr instanceof Object);  //true
        System.out.println(aArr instanceof I[]);  //true
        System.out.println(aArr instanceof A[]);  //true
        System.out.println(aArr instanceof B[]); //true

        /**
         * Probably because the actual type is B
         */
//        System.out.println(aArr instanceof I2);
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
        m4();
    }



}
