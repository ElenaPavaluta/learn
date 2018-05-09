package books.thinkigInJava._4ThEdition.chapters.generics.compensatingForErasure.creatingInstancesOfTypes.ex._22;

import com.sun.org.apache.xpath.internal.operations.String;

class C {

    public C(String s) {
        System.out.println( this.getClass().getSimpleName() + ": " + s);
    }
}
