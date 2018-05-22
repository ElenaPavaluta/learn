package oc.p.chapters.c_8_IO.workingWithStreams.objectInputStreamAndObjectOutputStream.understandingObjectCreation.tw._1;
/**
 * When you deserialize an object,
 * the constructor of the serialized class is not called.
 * In fact, Java calls the first no-arg constructor
 * for the first nonserializable parent class,
 * skipping the constructors of any serialized
 * class in between. Furthermore, any static
 * variables or default initializations are ignored.
 */
class A {

    public A() {
        System.out.println(this.getClass().getSimpleName() + " called") ;
    }

    public A(String s){
        System.out.println(this.getClass().getSimpleName() + " called with: " + s);
    }
}
