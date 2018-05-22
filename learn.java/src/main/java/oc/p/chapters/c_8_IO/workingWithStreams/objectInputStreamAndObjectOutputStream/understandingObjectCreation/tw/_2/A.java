package oc.p.chapters.c_8_IO.workingWithStreams.objectInputStreamAndObjectOutputStream.understandingObjectCreation.tw
        ._2;

class A {

    /**
     * The static initializer block isn't called, when the object is deserialize
     */
    static {
        System.out.println("s " + 1);
    }

    {
        System.out.println(1);
    }

    A() {
        System.out.println(2);
    }
}
