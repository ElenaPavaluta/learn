package oc.p.chapters._8_IO.workingWithStreams.objectInputStreamAndObjectOutputStream.understandingObjectCreation.tw._2;


import java.io.Serializable;

class C extends B implements Serializable{
    static {
        System.out.println("s " +3);
    }
    {
        System.out.println(5);
    }

    C(){
        System.out.println(6);
    }

    public static void main(String[] args) {
        new C();
    }
}
