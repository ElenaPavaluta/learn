package oc.p.chapters._8_IO.workingWithStreams.objectInputStreamAndObjectOutputStream.understandingObjectCreation.tw._2;


import java.io.Serializable;

class B extends A implements Serializable{
    static {
        System.out.println("s " + 2);
    }

    {
        System.out.println(3);
    }

    public B() {
        System.out.println(4);
    }
}
