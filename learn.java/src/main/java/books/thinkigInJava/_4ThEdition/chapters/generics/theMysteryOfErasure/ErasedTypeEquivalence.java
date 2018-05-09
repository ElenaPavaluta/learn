package books.thinkigInJava._4ThEdition.chapters.generics.theMysteryOfErasure;

import java.util.ArrayList;

/**
 * Although you can say ArrayList.class,
 * you cannot say ArrayList<Integer>.class.
 */
class ErasedTypeEquivalence {

    static void m(){
        Class c = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();

        System.out.println(c==c2);  //true
    }

    public static void main(String[] args) {
        m();
    }
}
